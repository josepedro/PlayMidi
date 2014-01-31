package assemblymidi;

import java.io.File;

public class AssemblerMidi {

	private int noteNumber;
	private byte[] bytesMidi = { (byte) 0x4D, (byte) 0x54, (byte) 0x68,
			(byte) 0x64, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x06,
			(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00,
			(byte) 0x80, (byte) 0x4D, (byte) 0x54, (byte) 0x72, (byte) 0x6B,
			(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x0B, (byte) 0x00,
			(byte) 0xC1, (byte) 0x40, (byte) 0x00, (byte) 0x91, (byte) 0x45,
			(byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x2F, (byte) 0x00 };
	private byte[] notesByte = new byte[12];
	private String[] nameNotes = { "do", "do#", "re", "re#", "mi", "fa", "fa#",
			"sol", "sol#", "la", "la#", "si" };

	public AssemblerMidi(int note) {
		// Mount notes
		byte noteMounting = 0X3C;
		for (int slot = 0; slot < notesByte.length; slot++) {
			notesByte[slot] = noteMounting;
			noteMounting++;
		}
		this.noteNumber = note;
	}

	public byte[] getassemblyMidi() {
		bytesMidi[27] = notesByte[noteNumber];
		return bytesMidi;
	}

	public String getNameNote() {
		return nameNotes[noteNumber];
	}

}
