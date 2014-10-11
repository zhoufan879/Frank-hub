package frank.lf;



import com.cybbj.bean.AudioBean;
import com.cybbj.process.DataProcess;
import com.cybbj.utils.Constants;
import com.cybbj.utils.Converts;

public class TestDataProcess {

	public static void main(String[] args) throws Exception {

		new TestDataProcess().testSample();

	}

	public void testSample() throws Exception {

		byte[] bKeyTMSK = { 0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32,
				0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32,
				0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32,
				0x32, 0x32, 0x32, 0x32 };

		byte[] bOKeyA = { 0x31, 0x31, 0x31, 0x31, 0x31, 0x31, 0x31, 0x31, 0x31,
				0x31, 0x31, 0x31, 0x31, 0x31, 0x31, 0x31, 0x31, 0x31, 0x31,
				0x31 };

		byte[] bOKeyB = { 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30,
				0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30,
				0x30 };

		long lClientCounter = 3640990167986571561L;
		long lServerCounter = 3640990167986571559L;

		String sCardNum = "6217001234567891234";
		String sCvvExp = "1780316";

		System.out.println("sMKey = " + Converts.bytesToHexString(bKeyTMSK));
		System.out.println("sOKeyA = " + Converts.bytesToHexString(bOKeyA));
		System.out.println("sOKeyB = " + Converts.bytesToHexString(bOKeyB));
		System.out.println("lCounterClient = " + lClientCounter);
		System.out.println("lCounterServer = " + lServerCounter);
		System.out.println("sCardNum = " + sCardNum);
		

		AudioBean audioBean = new AudioBean(sCardNum, bKeyTMSK, bOKeyA, bOKeyB,
				Constants.AES_32, lClientCounter, sCvvExp, "0000",1000);
		
		
		System.out.println("-------------数据加密------------");

		audioBean = DataProcess.dataEncryption(audioBean);

		System.out.println("audioBean.sCvvExp = " + audioBean.getsCvvExp());
		System.out.println("audioBean.sStates = " + audioBean.getsStates());

		System.out.println("----------------数据解密-------------");

		audioBean.setlCounter(lServerCounter);
		DataProcess.dataDecryption(audioBean);
		System.out.println("audioBean.lCounter = " + audioBean.getlCounter());
		System.out.println("audioBean.sCvvExp= " + audioBean.getsCvvExp());
		System.out.println("audioBean.sStates = " + audioBean.getsStates());
	}

}
