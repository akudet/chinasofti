package ex15;

import java.io.*;

public class ByteCharacterConvertion {

	public static void main(String[] args) {
		InputStreamReader isr;
		BufferedReader br;
		
		OutputStreamWriter osw;
		BufferedWriter bw;
		
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		
		osw = new OutputStreamWriter(System.out);
		bw = new BufferedWriter(osw);
		
		try {
			String line;
			while (null != (line = br.readLine())) {
				if (line.equals("end")) break;
				bw.write(line);
				bw.newLine();
				bw.flush();
			}
			
			
			br.close();
			isr.close();
			bw.close();
			osw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
