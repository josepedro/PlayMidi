package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		try {
			File saveFile = new File("MidiFiles/testMidifile.mid");
			if (saveFile.createNewFile()) {
				System.out.println("\n\nNovo arquivo criado");
			}
			FileOutputStream midiFile = new FileOutputStream(saveFile);

			byte[] midiBytes = { (byte) 0x4D, (byte) 0x54, (byte) 0x68,
					(byte) 0x64, (byte) 0x00, (byte) 0x00, (byte) 0x00,
					(byte) 0x06, (byte) 0x00, (byte) 0x00, (byte) 0x00,
					(byte) 0x01, (byte) 0x00, (byte) 0x80, (byte) 0x4D,
					(byte) 0x54, (byte) 0x72, (byte) 0x6B, (byte) 0x00,
					(byte) 0x00, (byte) 0x00, (byte) 0x0B, (byte) 0x00,
					(byte) 0xC1, (byte) 0x47, (byte) 0x00, (byte) 0x91,
					(byte) 0xB5, (byte) 0xFF, (byte) 0x00, (byte) 0xFF,
					(byte) 0x2F, (byte) 0x00 };
			
			for (int midiSlot = 0; midiSlot < midiBytes.length; midiSlot++) {
				midiFile.write(midiBytes[midiSlot]);
			}

			midiFile.close();
			System.out.println("Sucesso");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
