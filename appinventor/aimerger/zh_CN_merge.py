#!/usr/bin/python3
import configparser

def load_properties(file_path):
    """读取 .properties 文件，返回字典形式的键值对"""
    properties = {}
    with open(file_path, 'r', encoding='utf-8') as file:
        for line in file:
            line = line.strip()
            # 跳过空行和以#开头的注释行
            if not line or line.startswith('#'):
                continue
            if '=' in line:
                key, value = line.split('=', 1)
                properties[key.strip()] = value.strip()
    return properties

def merge_properties(source_file, target_file, new_file):
    """将 source_file 中的新键值对写入到 new_file 中"""
    source_properties = load_properties(source_file)
    target_properties = load_properties(target_file)

    # 找到只在 source 文件中存在但不在 target 文件中的键
    new_properties = {k: v for k, v in source_properties.items() if k not in target_properties}

    # 写回新的 .properties 文件
    with open(new_file, 'w', encoding='utf-8') as file:
        for key, value in new_properties.items():
            file.write(f"{key}={value}\n")

# 示例用法
source_file_path = 'MIT_OdeMessages_zh_CN.properties'
target_file_path = 'OdeMessages_zh_CN.properties'
new_file_path = 'new.properties'

merge_properties(source_file_path, target_file_path, new_file_path)
