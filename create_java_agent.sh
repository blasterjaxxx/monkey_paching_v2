#!/bin/bash

# Ensure the script is run from the correct directory
SCRIPT_DIR=$(dirname "$0")
cd "$SCRIPT_DIR" || exit

# Define variables
TARGET_DIR="/Users/sparshduggal/Downloads/project/target/classes"

# Ensure the target class directory exists
if [ ! -d "$TARGET_DIR" ]; then
  echo "Target directory $TARGET_DIR does not exist. Exiting..."
  exit 1
fi

# Function to create a JAR file
create_jar() {
  local jar_name=$1
  local premain_class=$2
  local class_path=$3
  local manifest_file=$(mktemp)

  echo "Creating manifest file for $jar_name..."
  echo "Manifest-Version: 1.0" > "$manifest_file"
  echo "Premain-Class: $premain_class" >> "$manifest_file"

  echo "Creating JAR file: $jar_name"

  # Ensure the class file exists
  if [ ! -f "$TARGET_DIR/$class_path" ]; then
    echo "Class file $TARGET_DIR/$class_path does not exist. Exiting..."
    exit 1
  fi

  # Create the JAR file
  jar cmf "$manifest_file" "$jar_name" -C "$TARGET_DIR" "$class_path"

  # Verify the JAR file was created
  if [ -f "$jar_name" ]; then
    echo "JAR file $jar_name created successfully."
  else
    echo "Failed to create JAR file $jar_name. Exiting..."
    exit 1
  fi

  # Clean up
  rm "$manifest_file"
}

# Create the first JAR file
create_jar "resttemplate-intercept-agent.jar" "com.monkey.project.RestTemplateInterceptorAgent" "com/monkey/project/RestTemplateInterceptorAgent.class"

# Create the second JAR file
create_jar "jpa-intercept-agent.jar" "com.monkey.project.JpaInterceptorAgent" "com/monkey/project/JpaInterceptorAgent.class"

echo "Done."