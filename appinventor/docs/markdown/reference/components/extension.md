---
layout: documentation
title: 中文网（自研/维护）拓展
description: 中文网（自研/维护）拓展参考文档：包括AliSms 拓展：短信平台接入，短信验证码；Clipboard 拓展：实现剪贴板的复制粘贴功能；PhoneInfo 拓展：获取手机等设备软硬件、版本等相关信息；SQLite 拓展：超流行兼容主流SQL语法的迷你本地数据库引擎。
---

* TOC
{:toc}

[&laquo; 返回首页](index.html)
# <i class="mdi mdi-puzzle-plus-outline"></i>  中文网（自研/维护）拓展

目录：

* [![logo](../extensions/icons/sendsms.png) AliSms：阿里云短信平台接入，短信验证码](#AliSms)
* [![logo](../extensions/icons/clipboard.png) Clipboard：实现剪贴板的复制粘贴功能](#Clipboard)
* [![logo](../extensions/icons/phoneinfo.png) PhoneInfo：获取手机等设备软硬件、版本等相关信息](#PhoneInfo)
* [![logo](../extensions/icons/sqlite.png) SQLite：超流行兼容主流SQL语法的迷你本地数据库引擎](#SQLite)

## ![logo](../extensions/icons/sendsms.png) AliSms   {#AliSms}

阿里云短信平台接入，短信验证码。详细用法及步骤请参考[这里](../pro/alisms.html?f=ext)。

### 属性  {#AliSms-Properties}

{:.properties}

{:id="AliSms.AccessKeyId" .text .wo} *AccessKeyId*
: AccessKey ID

{:id="AliSms.AccessKeySecret" .text .wo} *AccessKeySecret*
: AccessKey Secret

### 事件  {#AliSms-Events}

{:.events}
None


### 方法  {#AliSms-Methods}

{:.methods}

{:id="AliSms.RandomNumCode" class="method returns text"} <i/> RandomNumCode(*length*{:.number})
: 返回一个指定位数随机数字码。

{:id="AliSms.SendSms" class="method"} <i/> SendSms(*phoneNumber*{:.text},*signName*{:.text},*templateCode*{:.text},*templateParam*{:.text})
: 发送短信。参数：手机号，签名名称，模板CODE，模板参数JSON

## ![logo](../extensions/icons/clipboard.png) Clipboard  {#Clipboard}

实现剪贴板的复制粘贴功能。详细用法及步骤请参考[这里](../extensions/clipboard.html?f=ext)。

**可跨屏幕共享剪贴板数据**，可作为屏幕间数据传输的一种备选方式。

### 属性  {#Clipboard-Properties}

{:.properties}

{:id="Clipboard.SuppressToast" .boolean} *SuppressToast*
: 默认操作成功后显示提示信息，SuppressToast设置为 `假` 后，则不显示提示信息。

### 事件  {#Clipboard-Events}

{:.events}
None


### 方法  {#Clipboard-Methods}

{:.methods}

{:id="Clipboard.Copy" class="method"} <i/> Copy(*text*{:.text})
: 拷贝文本到剪贴板。

{:id="Clipboard.Paste" class="method returns text"} <i/> Paste()
: 从剪贴板粘贴内容并返回文本。

## ![logo](../extensions/icons/phoneinfo.png) PhoneInfo  {#PhoneInfo}

获取手机等设备软硬件、版本等相关信息。详细用法及步骤请参考[这里](../extensions/phoneinfo.html?f=ext)。

### 属性  {#PhoneInfo-Properties}

{:.properties}
None


### 事件  {#PhoneInfo-Events}

{:.events}
None


### 方法  {#PhoneInfo-Methods}

{:.methods}

{:id="PhoneInfo.GetDeviceID" class="method returns text"} <i/> GetDeviceID()
: 获取设备ID

{:id="PhoneInfo.GetMacAddress" class="method returns text"} <i/> GetMacAddress()
: 获取网卡MAC地址信息

{:id="PhoneInfo.GetPhoneModel" class="method returns text"} <i/> GetPhoneModel()
: 获取本机手机型号

{:id="PhoneInfo.GetPhoneNumber" class="method returns text"} <i/> GetPhoneNumber()
: 获取本机手机号码。无SIM卡设备将返回空文本；双SIM卡设备将返回主卡号码。

{:id="PhoneInfo.GetReleaseVersion" class="method returns text"} <i/> GetReleaseVersion()
: 获取系统版本

{:id="PhoneInfo.GetSDKVersion" class="method returns text"} <i/> GetSDKVersion()
: 获取SDK版本

## ![logo](../extensions/icons/sqlite.png) SQLite  {#SQLite}

超流行兼容主流SQL语法的迷你本地数据库引擎。详细用法及步骤请参考[这里](../extensions/sqlite.html?f=ext)。

### 属性  {#SQLite-Properties}

{:.properties}

{:id="SQLite.DBName" .text} *DBName*
: Name of the database.

{:id="SQLite.DBVersion" .number} *DBVersion*
: Version of the database.

{:id="SQLite.DebugDialog" .boolean} *DebugDialog*
: Display debugging messages as alerts.

{:id="SQLite.DebugToast" .boolean} *DebugToast*
: Display debugging messages as toast messages.

{:id="SQLite.ReturnColumnNames" .boolean} *ReturnColumnNames*
: Should result lists contain column names.

### 事件  {#SQLite-Events}

{:.events}

{:id="SQLite.AfterDelete"} AfterDelete(*tag*{:.text},*rowCount*{:.number})
: This event fires after an asynchronous Delete call. The tag specified in the original call and the number of deleted rows are provided.

{:id="SQLite.AfterExecute"} AfterExecute(*tag*{:.text},*result*{:.boolean})
: This event fires after an ExecuteSQLAsync call. The tag specified in the original call and the result of the execution are provided.

{:id="SQLite.AfterExecuteFile"} AfterExecuteFile(*tag*{:.text},*execCount*{:.number})
: This event fires after an ExecuteFileAsync. The tag specified in the original call and the result of the execution are provided.

{:id="SQLite.AfterInsert"} AfterInsert(*tag*{:.text},*rowId*{:.number})
: This event fires after an asynchronous Insert call. The tag specified in the original call and the row ID of the new row are provided.

{:id="SQLite.AfterInsertFile"} AfterInsertFile(*tag*{:.text},*rowCount*{:.number})
: This event fires after an asynchronous InsertFile call. The tag specified in the original call and the count of inserted rows are provided.

{:id="SQLite.AfterReplace"} AfterReplace(*tag*{:.text},*rowId*{:.number})
: This event fires after an asynchronous Replace call. The tag specified in the original call and the row ID of the new or updated row are provided.

{:id="SQLite.AfterSelect"} AfterSelect(*tag*{:.text},*rowCount*{:.number},*rows*{:.list})
: This event fires after an asynchronous Select call. The tag specified in the original call, the number of returned rows, and the result rows are provided.

{:id="SQLite.AfterUpdate"} AfterUpdate(*tag*{:.text},*rowCount*{:.number})
: This event fires after an asynchronous Update call. The tag specified in the original call and the number of changed rows are provided.

{:id="SQLite.DatabaseClosed"} DatabaseClosed()
: This event fires when the database is closed.

{:id="SQLite.DatabaseCreated"} DatabaseCreated()
: This event fires when the database is created.

{:id="SQLite.DatabaseDowngrade"} DatabaseDowngrade(*oldVersion*{:.number},*newVersion*{:.number})
: This event fires when the database is downgraded. The previous and new version numbers are provided. Use this event to modify the database as required by the version change.

{:id="SQLite.DatabaseOpened"} DatabaseOpened()
: This event fires when the database is opened.

{:id="SQLite.DatabaseUpgrade"} DatabaseUpgrade(*oldVersion*{:.number},*newVersion*{:.number})
: This event fires when the database is upgraded. The previous and new version numbers are provided. Use this event to modify the database as required by the version change.

{:id="SQLite.SQLError"} SQLError(*message*{:.text})
: This event fires when a SQL error occurs. The error message is provided.

### 方法  {#SQLite-Methods}

{:.methods}

{:id="SQLite.BeginTransaction" class="method"} <i/> BeginTransaction()
: Begin a transaction.

{:id="SQLite.CloseDatabase" class="method"} <i/> CloseDatabase()
: Closes the database.

{:id="SQLite.CommitTransaction" class="method"} <i/> CommitTransaction()
: Commit a transaction.

{:id="SQLite.DatabaseExists" class="method returns boolean"} <i/> DatabaseExists()
: Returns true if the database file exists, false otherwise.

{:id="SQLite.DatabasePath" class="method returns text"} <i/> DatabasePath()
: Returns the path to the database.

{:id="SQLite.Delete" class="method returns number"} <i/> Delete(*table*{:.text},*whereClause*{:.text},*bindParams*{:.list})
: Executes a SQL DELETE statement.

{:id="SQLite.DeleteAsync" class="method"} <i/> DeleteAsync(*tag*{:.text},*table*{:.text},*whereClause*{:.text},*bindParams*{:.list})
: Executes a SQL DELETE statement, asynchronously.

{:id="SQLite.DeleteDatabase" class="method"} <i/> DeleteDatabase()
: Delete the database.

{:id="SQLite.Execute" class="method returns boolean"} <i/> Execute(*sql*{:.text},*bindParams*{:.list})
: Execute a single, parameterized SQL statement that is NOT a SELECT.

{:id="SQLite.ExecuteAsync" class="method"} <i/> ExecuteAsync(*tag*{:.text},*sql*{:.text},*bindParams*{:.list})
: Execute a single, parameterized SQL statement that is NOT a SELECT, asynchronously.

{:id="SQLite.ExecuteFile" class="method returns number"} <i/> ExecuteFile(*fileName*{:.text})
: Execute multiple SQL statements from a file.

{:id="SQLite.ExecuteFileAsync" class="method"} <i/> ExecuteFileAsync(*tag*{:.text},*fileName*{:.text})
: Execute multiple SQL statements from a file, asynchronously.

{:id="SQLite.ExportDatabase" class="method returns boolean"} <i/> ExportDatabase(*fileName*{:.text})
: Exports the database.
 This is probably not best done on the main thread.

{:id="SQLite.ImportDatabase" class="method returns boolean"} <i/> ImportDatabase(*fileName*{:.text})
: Import a SQLite database file.
 This is probably not best done on the main thread.

{:id="SQLite.Insert" class="method returns number"} <i/> Insert(*table*{:.text},*columns*{:.list},*values*{:.list})
: Executes a SQL INSERT statement.

{:id="SQLite.InsertAsync" class="method"} <i/> InsertAsync(*tag*{:.text},*table*{:.text},*columns*{:.list},*values*{:.list})
: Executes a SQL INSERT statement, asynchronously.

{:id="SQLite.InsertFile" class="method returns number"} <i/> InsertFile(*table*{:.text},*fileName*{:.text})
: Inserts rows from a file.

{:id="SQLite.InsertFileAsync" class="method"} <i/> InsertFileAsync(*tag*{:.text},*table*{:.text},*fileName*{:.text})
: Inserts rows from a file, asynchronously.

{:id="SQLite.IsDatabaseOpen" class="method returns boolean"} <i/> IsDatabaseOpen()
: Indicates if the database has been opened or not.

{:id="SQLite.OpenDatabase" class="method"} <i/> OpenDatabase()
: Opens the database.

{:id="SQLite.Replace" class="method returns number"} <i/> Replace(*table*{:.text},*columns*{:.list},*values*{:.list})
: Executes a SQL REPLACE statement.

{:id="SQLite.ReplaceAsync" class="method"} <i/> ReplaceAsync(*tag*{:.text},*table*{:.text},*columns*{:.list},*values*{:.list})
: Executes a SQL REPLACE statement, asynchronously.

{:id="SQLite.RollbackTransaction" class="method"} <i/> RollbackTransaction()
: Rollback a transaction.

{:id="SQLite.Select" class="method returns list"} <i/> Select(*table*{:.text},*distinct*{:.boolean},*columns*{:.list},*whereClause*{:.text},*bindParams*{:.list},*groupBy*{:.text},*having*{:.text},*orderBy*{:.text},*limit*{:.text})
: Executes a SQL SELECT statement.

{:id="SQLite.SelectAsync" class="method"} <i/> SelectAsync(*tag*{:.text},*table*{:.text},*distinct*{:.boolean},*columns*{:.list},*whereClause*{:.text},*bindParams*{:.list},*groupBy*{:.text},*having*{:.text},*orderBy*{:.text},*limit*{:.text})
: Executes a SQL SELECT statement, asynchronously.

{:id="SQLite.SelectSQL" class="method returns list"} <i/> SelectSQL(*sql*{:.text},*bindParams*{:.list})
: Execute a single, parameterized SQL SELECT statement and returns a list of records.

{:id="SQLite.SelectSQLAsync" class="method"} <i/> SelectSQLAsync(*tag*{:.text},*sql*{:.text},*bindParams*{:.list})
: Execute a single, parameterized SQL SELECT statement, asynchronously.

{:id="SQLite.TableCount" class="method returns number"} <i/> TableCount()
: Returns the number of tables in the database.

{:id="SQLite.TableExists" class="method returns boolean"} <i/> TableExists(*table*{:.text})
: Returns true if the table exists in the database, false otherwise.

{:id="SQLite.TableNames" class="method returns list"} <i/> TableNames()
: Returns a list of names of the tables in the the database.

{:id="SQLite.TableRowCount" class="method returns number"} <i/> TableRowCount(*table*{:.text})
: Returns the number of records in a table.

{:id="SQLite.Update" class="method returns number"} <i/> Update(*table*{:.text},*columns*{:.list},*values*{:.list},*whereClause*{:.text},*bindParams*{:.list})
: Executes a SQL UPDATE statement.

{:id="SQLite.UpdateAsync" class="method"} <i/> UpdateAsync(*tag*{:.text},*table*{:.text},*columns*{:.list},*values*{:.list},*whereClause*{:.text},*bindParams*{:.list})
: Executes a SQL UPDATE statement, asynchronously.
