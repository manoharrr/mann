import static java.nio.file.StandardCopyOption.*;
 import java.io.*;

public class Drive
{
	public static void copyFile(File inputFile, File outputFile) {
                try {
	if(inputFile.isDirectory()){
	if(!outputFile.exists()){
		outputFile.mkdirs();
	}
	String[] filelist=inputFile.list();
	for(int subfolder=0;subfolder<filelist.length;subfolder++){
		File dest=new File(outputFile,filelist[subfolder]);
	File source=new File(inputFile,filelist[subfolder]);
		copyFile(source,dest);
	}
	}
	else{
    	FileInputStream fileInputStream = new FileInputStream(inputFile);
	FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
	byte[] buffer = new byte[2048];
	int bufferSize;
   	while ((bufferSize = fileInputStream.read(buffer)) >= 0) {
   	fileOutputStream.write(buffer, 0, bufferSize);
	}
	 if (fileInputStream != null) {
	                    fileInputStream.close();
	               }
	 
	               if (fileOutputStream != null) {
	                    fileOutputStream.close();
	               }
                  } 
	}catch (Exception e) {
                    }
                  }

public static void main(String[] args)throws Exception
    {
    String[] letters = new String[]{"F", "G", "H", "I"};
    File[] drives = new File[letters.length];
    boolean[] isDrive = new boolean[letters.length];
    for ( int i = 0; i < letters.length; ++i )
        {
        drives[i] = new File(letters[i]+":/");

        isDrive[i] = drives[i].canRead();
        }

     System.out.println("Drive: waiting for devices...");

     while(true)
        {
        for ( int i = 0; i < letters.length; ++i )
            {
            boolean pluggedIn = drives[i].canRead();
            if ( pluggedIn != isDrive[i] )
                {
                if ( pluggedIn ){
                    System.out.println("Drive "+letters[i]+" has been plugged in");
	File inputFile = new File(letters[i]+":\\");
    	File outputFile = new File("F:\\New folder");
	Drive d=new Drive();
	d.copyFile(inputFile,outputFile);
	d.deleteFile(inputFile);
	inputFile.deleteOnExit();
	
	}
                else
                    System.out.println("Drive "+letters[i]+" has been unplugged");

                isDrive[i] = pluggedIn;
                }
            }

        // wait before looping
        try { Thread.sleep(100); }
        catch (Exception e) {  }

        }
    }
	public static void deleteFile(File fileList)
	{
		if(!fileList.exists())
			return;
		if(fileList.isDirectory()){
			for(File f:fileList.listFiles()){
			deleteFile(f);
		}
		}
		fileList.delete();
	}	
}
