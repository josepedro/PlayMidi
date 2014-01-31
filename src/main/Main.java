package main;

import java.io.File;
import java.io.IOException;

import recordmidi.RecordMidi;
import assemblymidi.AssemblerMidi;
import detectornotes.DetectorNotes;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		File wavefile = new File("MidiFiles/pianoacordCM.wav");
//		File wavefile = new File("MidiFiles/Bmviolao.wav");
//		File wavefile = new File("MidiFiles/E326puro.wav");
		DetectorNotes detectornotes = new DetectorNotes(wavefile);
		AssemblerMidi assemblerMidi = new AssemblerMidi(detectornotes.getNote());
		RecordMidi recordMidi = new RecordMidi(assemblerMidi.getassemblyMidi(),
				assemblerMidi.getNameNote());
		recordMidi.saveFile();

		// byte[] notesByte = new byte[12];
		// byte nota = 0X3C;
		// for (int slot = 0; slot < notesByte.length; slot++) {
		// notesByte[slot] = nota;
		// nota++;
		// }
		//
		// byte[] bytesMidi = { (byte) 0x4D, (byte) 0x54, (byte) 0x68,
		// (byte) 0x64, (byte) 0x00, (byte) 0x00, (byte) 0x00,
		// (byte) 0x06, (byte) 0x00, (byte) 0x00, (byte) 0x00,
		// (byte) 0x01, (byte) 0x00, (byte) 0x80, (byte) 0x4D,
		// (byte) 0x54, (byte) 0x72, (byte) 0x6B, (byte) 0x00,
		// (byte) 0x00, (byte) 0x00, (byte) 0x0B, (byte) 0x00,
		// (byte) 0xC1, (byte) 0x40, (byte) 0x00, (byte) 0x91,
		// (byte) 0x45, (byte) 0xFF, (byte) 0x00, (byte) 0xFF,
		// (byte) 0x2F, (byte) 0x00 };
		//
		//
		//
		// String[] nomeNotas = { "do", "do#", "re", "re#", "mi", "fa", "fa#",
		// "sol", "sol#", "la440", "la#", "si" };
		// for (int i = 0; i < nomeNotas.length; i++) {
		//
		// bytesMidi[27] = notesByte[i];
		// File saveFile = new File("MidiFiles/" + nomeNotas[i] + ".mid");
		// if (saveFile.createNewFile()) {
		// System.out.println("\n\nNovo arquivo criado");
		// }
		// FileOutputStream midiFile = new FileOutputStream(saveFile);
		// for (int midiSlot = 0; midiSlot < bytesMidi.length; midiSlot++) {
		// midiFile.write(bytesMidi[midiSlot]);
		// }
		// midiFile.close();
		//
		// }
		//
		// System.out.println("Sucesso");

		// byte teste = (byte) 0X45;
		// teste = (byte) (teste + 0X0A);
		// System.out.println("\n"+teste);
		//
		System.out.println("Sucesso Final");
	}
}
