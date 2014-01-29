package assemblymidi;

public class AssemblerMidi {
	
	private String note;
	private byte[] la4bytes = { (byte) 0x4D, (byte) 0x54, (byte) 0x68,
			(byte) 0x64, (byte) 0x00, (byte) 0x00, (byte) 0x00,
			(byte) 0x06, (byte) 0x00, (byte) 0x00, (byte) 0x00,
			(byte) 0x01, (byte) 0x00, (byte) 0x80, (byte) 0x4D,
			(byte) 0x54, (byte) 0x72, (byte) 0x6B, (byte) 0x00,
			(byte) 0x00, (byte) 0x00, (byte) 0x0B, (byte) 0x00,
			(byte) 0xC1, (byte) 0x40, (byte) 0x00, (byte) 0x91,
			(byte) 0x45, (byte) 0xFF, (byte) 0x00, (byte) 0xFF,
			(byte) 0x2F, (byte) 0x00 };
	
	public AssemblerMidi(String note){
		this.note = note;
	}
	
	public byte[] assemblyMidi(){
		if (note == "la4") {
			return la4bytes;
		}
		else {
			return null;
		}
		
	}

}
