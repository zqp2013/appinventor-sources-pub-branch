//  OCRSpace extension for App Inventor by Marco Perrone

package OCRSpace;

import com.google.appinventor.components.runtime.*;
import android.app.Activity;
import android.content.Intent;
			
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.annotations.UsesActivities;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesActivityMetadata;
import com.google.appinventor.components.annotations.androidmanifest.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.util.GingerbreadUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.AsynchUtil;


 
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Map;

import java.net.CookieHandler;

import java.nio.file.Path;
import java.nio.file.Paths;



import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.OutputStream;





@SimpleObject(external=true)
@UsesPermissions(permissionNames = "android.permission.INTERNET,android.permission.READ_EXTERNAL_STORAGE,android.permission.WRITE_EXTERNAL_STORAGE")

@DesignerComponent(version = YaVersion.WEB_COMPONENT_VERSION,
    description = "<p>Non-visible OCR component to convert image to text.", 
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "images/nearfield.png")
	
public class OCRSpace extends AndroidNonvisibleComponent implements Component {

	private final Activity activity;
	private final CookieHandler cookieHandler;
	private String twoHyphens = "--";
	private String boundary =  "*****"+Long.toString(System.currentTimeMillis())+"*****";
	private String LINE = "\r\n";
	private URL url;
	private HttpURLConnection httpConn = null;
	private OutputStream outputStream;
    private PrintWriter writer;
	private String charset = "utf-8"; 
	
	@SimpleEvent(description = "Get OCR Response")
	public void GetOCRResponse(int responseCode,String response, String parsedText) {
    
		EventDispatcher.dispatchEvent(this, "GetOCRResponse", responseCode, response, parsedText);
	}
	
	
  
	@SimpleFunction(description = "OCR from File.")
	public void OCRFromFile(final String objectLocation,  final String apiKey, final String language, final String fileType, final boolean scale, final int ocrEngine) {
	  AsynchUtil.runAsynchronously(new Runnable() {
      @Override
      public void run() {
        try {	
			OCRFromFile_Exec(apiKey, objectLocation, language, fileType, scale, ocrEngine);	
		}
		catch(IOException e) {
			e.printStackTrace();
		}	  
      }
	  });
	}
	@SimpleFunction(description = "OCR from URL.")
	public void OCRFromURL(final String url,  final String apiKey, final String language) {
	  AsynchUtil.runAsynchronously(new Runnable() {
      @Override
	  public void run() {	
		OCRFromURL_Exec(apiKey, url, language);	  
      }
	  });
      
	}
	
  
 public OCRSpace(ComponentContainer container) {
    super(container.$form());
    activity = container.$context();
    cookieHandler = (SdkLevel.getLevel() >= SdkLevel.LEVEL_GINGERBREAD)
        ? GingerbreadUtil.newCookieManager()
        : null;
  }

void OCRFromFile_Exec(String APIKEY, String OBJECT_LOCATION, String LANGUAGE, String FILETYPE, boolean SCALE, int OCRENGINE) throws IOException {

		Path path = Paths.get(URI.create(OBJECT_LOCATION));	
		byte[] buffer = java.nio.file.Files.readAllBytes(path);
		PerformOCR(buffer, path.toString(), APIKEY, LANGUAGE, FILETYPE, SCALE, OCRENGINE);
		
}

void OCRFromURL_Exec(String APIKEY, String URL, String LANGUAGE) {
	try
	{	
		InputStream inputStream = null;	
		String URLStr = "https://api.ocr.space/parse/imageurl";
		URLStr = URLStr + "?apikey=" + APIKEY;
		URLStr = URLStr + "&url=" + URL;
		URLStr = URLStr + "&language=" + LANGUAGE; 
		URL url = new URL(URLStr);
        httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");
		final int status = httpConn.getResponseCode();
		String ParseText = "";
        if (status == HttpURLConnection.HTTP_OK) {
			inputStream = httpConn.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
			
			String inputLine;
			final StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}	
			final String responseStr = response.toString();
            httpConn.disconnect();
			if (responseStr.indexOf("ParsedText") != -1)
			{
				ParseText = responseStr.substring(responseStr.indexOf("ParsedText\":\""));
				ParseText = ParseText.substring(ParseText.indexOf("\"")+3);
				ParseText = ParseText.substring(0,ParseText.indexOf("\""));
			}
			final String parseTextFin = ParseText; 
			// Dispatch the event.
			activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					GetOCRResponse(status, responseStr, parseTextFin);
				}
			}); 
		}
		else {
				InputStream inputStreamErr = httpConn.getErrorStream();
				BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getErrorStream()));
				String inputLine;
				final StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}	
				final String responseStr = response.toString();
				httpConn.disconnect();
				// Dispatch the event.
				activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					GetOCRResponse(status, responseStr , "");
				}
			}); 
			
		}
	}
	catch (Exception e) {
		e.printStackTrace();
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		appendLog(errors.toString());
	}
}


public void PerformOCR(byte[] buffer, String path, String apikey, String language, String fileType, boolean scale, int ocrEngine)
{	
	InputStream inputStream = null;	
	try
	{	
		URL url = new URL("https://api.ocr.space/parse/image");
        httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setUseCaches(false);
        httpConn.setDoOutput(true);    
        httpConn.setDoInput(true);
		httpConn.setRequestMethod("POST");
		httpConn.setRequestProperty("Connection", "Keep-Alive");
		httpConn.setRequestProperty("User-Agent", "Android Multipart HTTP Client 1.0");
		httpConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
		httpConn.setRequestProperty("apikey", apikey);
      
        outputStream = new DataOutputStream(httpConn.getOutputStream());

		writer = new PrintWriter(outputStream, true);
		// Add form field
		addFormField("language", language);
		addFormField("filetype", fileType);
		String scaleStr = new Boolean(scale).toString();
		addFormField("scale", scaleStr);
		String ocrEngineStr = String.valueOf(ocrEngine);
		addFormField("OCREngine", ocrEngineStr);
		// Add file
		addFilePart(buffer, "imgFile", new File(path));
		int bufferSize = buffer.length;
		try
		{
			outputStream.write(buffer, 0, bufferSize);
		}
		catch (IOException e) {
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			appendLog(errors.toString());
		}	
        outputStream.flush();
		writer.append(LINE);
        writer.flush();
		writer.append("--" + boundary + "--").append(LINE);
		writer.close();
		outputStream.close();	
        final int status = httpConn.getResponseCode();
		if (status == HttpURLConnection.HTTP_OK) {
			inputStream = httpConn.getInputStream();
			String ParseText = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));		
			String inputLine;
			final StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			inputStream.close();
			
			final String responseStr = response.toString();
            httpConn.disconnect();
			if (responseStr.indexOf("ParsedText") != -1)
			{
				ParseText = responseStr.substring(responseStr.indexOf("ParsedText\":\""));
				ParseText = ParseText.substring(ParseText.indexOf("\"")+3);
				ParseText = ParseText.substring(0,ParseText.indexOf("\""));
			}
			final String parseTextFin = ParseText; 
			// Dispatch the event.
			activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					GetOCRResponse(status, responseStr, parseTextFin);
				}
			}); 
		}
		else {
				InputStream inputStreamErr = httpConn.getErrorStream();
				BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getErrorStream()));
				String inputLine;
				final StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}	
				final String responseStr = response.toString();
				httpConn.disconnect();
				// Dispatch the event.
				activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					GetOCRResponse(status, responseStr , "");
				}
			}); 
			
		}
	}
	catch (Exception e) {
		e.printStackTrace();
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		appendLog(errors.toString());
	}
}


	    /**
     * Adds a form field to the request
     *
     * @param name  field name
     * @param value field value
     */
    public void addFormField(String name, String value) {
        writer.append("--" + boundary).append(LINE);
        writer.append("Content-Disposition: form-data; name=\"" + name + "\"").append(LINE);
        writer.append("Content-Type: text/plain; charset=" + charset).append(LINE);
        writer.append(LINE);
        writer.append(value).append(LINE);
        writer.flush();
    }

    /**
     * Adds a upload file section to the request
     *
     * @param fieldName
     * @param uploadFile
     * @throws IOException
     */
    public void addFilePart(byte[] buffer, String fieldName, File uploadFile)
            throws IOException {
        String fileName = uploadFile.getName();
        writer.append("--" + boundary).append(LINE);
        writer.append("Content-Disposition: form-data; name=\"" + fieldName + "\"; filename=\"" + fileName + "\"").append(LINE);
		writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(fileName)).append(LINE);
		writer.append("Content-Transfer-Encoding: binary").append(LINE);
        writer.append(LINE);
        writer.flush();     
    }

public void appendLog(String text)
{       
   File logFile = new File("sdcard/FileStackLog.txt");
   if (!logFile.exists())
   {
      try
      {
         logFile.createNewFile();
      } 
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   try
   {
      //BufferedWriter for performance, true to set append to file flag
      BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true)); 
      buf.append(text);
      buf.newLine();
	  buf.flush();
      buf.close();
   }
   catch (IOException e)
   {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
}
}