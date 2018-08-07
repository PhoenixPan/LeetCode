import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Filter {
    public static void main(String args[]) {
        File folder = new File("E:/Github/LeetCode");
        listFilesForFolder(folder);
    }
    
    public static void listFilesForFolder(File folder) {
        File[] files = folder.listFiles();
		String sourcePath = "E:/Github/LeetCode/";
		String targetPath = "E:/Github/leet/";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fileDate = null;
				
        //System.out.println("Items:" + files);
        for (File file : files) {
			String fileName = file.getName();
			if (fileName.equals(".git")) {
				continue;
			}
			
			String newName = file.getName().substring(0, fileName.length() - 3).toLowerCase().replaceAll("(\\.| )+", "-") + ".md";
			String headDate = formatter.format(new Date(file.lastModified()));
			// get String: SimpleDateFormat.format(Date)
			// get Date: SimpleDateFormat.parse(String)
			
			try (BufferedReader br = new BufferedReader(new FileReader(sourcePath + fileName));
				BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath + newName))) {
					
				bw.write("---\n");
				bw.write("title: " + fileName.substring(0, fileName.length() - 3) + "\n");
				bw.write("categories: " + "LeetCode" + "\n");
				bw.write("date: " + headDate + "\n");
				bw.write("---\n");
				
				String line;
				while ((line = br.readLine()) != null) {
					//System.out.println("read:" + line);
					bw.write(line + "\n");
				}				
				
				fileDate = new Date(file.lastModified());

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			File newFile = new File(targetPath + newName);
			newFile.setLastModified(fileDate.getTime());
        }
    }
}
