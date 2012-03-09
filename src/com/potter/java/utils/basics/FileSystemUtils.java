package com.potter.java.utils.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileSystemUtils {

	public static boolean copyFile(String srcFile, String dstFile){
		try{
			File f1 = new File(srcFile);
			File f2 = new File(dstFile);
			InputStream in = new FileInputStream(f1);

			//Append to the file.
			//  OutputStream out = new FileOutputStream(f2,true);

			//Overwrite the file.
			OutputStream out = new FileOutputStream(f2);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0){
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
			System.out.println("File copied.");
			return f2.exists();
		}
		catch(FileNotFoundException ex){
			System.out.println(ex.getMessage() + " in the specified directory.");
			System.exit(0);
		}
		catch(IOException e){
			System.out.println(e.getMessage());  
		}
		return false;
	}
	
	public static boolean renameFile(String fromFile, String toFile) {

		File toBeRenamedFile = new File(fromFile);

		if (!toBeRenamedFile.exists() || toBeRenamedFile.isDirectory()) {

			System.out.println("File does not exist: " + fromFile);
			return false;
		}

		File newNameFile = new File(toFile);

		//Rename the file and return success or failure.
		if (toBeRenamedFile.renameTo(newNameFile)) {
			System.out.println("File: [" + fromFile + "] has been renamed to: [" + toFile + "].");
			return true;
		}
		System.out.println("Error renmaing file: [" + fromFile + "]");
		return false;
	}

	public static void zipDirectory(String directory, String zipfile) 
	throws IOException, IllegalArgumentException {

		File dir = new File(directory);
		if (dir == null || !dir.exists() || !dir.isDirectory()){
			throw new IllegalArgumentException("Not a directory:  [" + directory + "]");
		}
		String[] entries = dir.list();
		byte[] buffer = new byte[4096]; 
		int bytes;

		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));

		for (int i = 0; i < entries.length; i++) {
			File file = new File(dir, entries[i]);
			if (file.isDirectory()){
				continue;//Ignore
			}
			FileInputStream in = new FileInputStream(file); 
			ZipEntry entry = new ZipEntry(file.getPath());
			out.putNextEntry(entry);
			while ((bytes = in.read(buffer)) != -1){
				out.write(buffer, 0, bytes);
			}
			in.close(); 
		}
		out.close();
	}
	
	/**
	 * Deletes all sub files and sub directories in the given directory.
	 * 
	 * @param dir Directory to be emptied
	 * @return
	 */
	public static boolean emptyDirectory(File dir){
		//recursive stop algorithm. 
		if(dir == null){
			return false;
		}else if(!dir.exists()){
			return true;
		}
		
		String[] list = dir.list();
		for (int i = 0; i < list.length; i++) {
			File item = new File(dir,list[i]);
			if(item.isDirectory()){
				if(!emptyDirectory(item)){
					System.out.println("Cannot Delete directory: [" + item.getPath() + "]");
					return false;
				}else{
					item.delete();
				}
			}else if(item.isFile()){
				if(!item.delete()){
					System.out.println("Cannot Delete file: [" + item.getPath() + "]");
					return false;
				}
			}
		}
		return true;
	}
}
