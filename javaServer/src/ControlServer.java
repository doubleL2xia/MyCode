import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class ControlServer {

	private static Socket mSocket;
	public static int desktopWidth = 0;
	public static int desktopHeight = 0;
	
	
	
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		
		desktopWidth = Toolkit.getDefaultToolkit().getScreenSize().width; //����Ŀ�

		desktopHeight = Toolkit.getDefaultToolkit().getScreenSize().height;  //����ĸ�
				
		ServerSocket ss = new ServerSocket(40000);
		while(true){
			mSocket = ss.accept();//�˴����һֱ����ֱ���пͻ��˷�������������
			System.out.println("���ӳɹ�");
			new Thread(new ServerThread(mSocket)).start();//����һ���̴߳������Կͻ��˵�����
		}	
	}
	
	
	
	
}

 class ServerThread implements Runnable{
	 private Socket mScoket;
	 private BufferedReader br;
	 private Robot rr = null;
	 
	public ServerThread(Socket mSocket) throws IOException, AWTException{
		this.mScoket = mSocket;
		this.br = new BufferedReader(new InputStreamReader(this.mScoket.getInputStream()));
		rr = new Robot();
	}
	
	 
	public void run(){
		String content = null;
		Point point = null;
		try {
			while((content = this.br.readLine()) != null){
				//���ݴ��͹�������Ϣ�������Ӧ�Ĳ���
			//System.out.println(content);
//				//����
				
				if(content.length() != 1){//������ƶ�ָ��(ע�������ƶ�ָ��:"0|1 x y"���⣬������ָ���һ���ַ�����)
					//System.out.println(0);
					String[] moveInfo = content.split(" ");
					int[] moveOrder = new int[3];
					
					moveOrder[0] = Integer.parseInt(moveInfo[0]);
					moveOrder[1] = (int)Float.parseFloat(moveInfo[1]);//x�����ƶ��ľ���
					moveOrder[2] = (int)Float.parseFloat(moveInfo[2]);//y�����ƶ��ľ���
					point = MouseInfo.getPointerInfo().getLocation();//�õ���ǰ������Ļ����
					int mouse_x = (int)point.getX(); 
					int mouse_y = (int)point.getY();
					if(moveOrder[0] == 0){
						int move_x = moveOrder[1] + mouse_x;
						int move_y = moveOrder[2] + mouse_y;
						if(move_x > 0 && move_y > 0 && move_x < ControlServer.desktopWidth && move_y < ControlServer.desktopHeight){
							rr.mouseMove(move_x,move_y);//�ƶ����
						}
					}else if(moveOrder[0] == 1){
						rr.mouseWheel(moveOrder[1]);
					}
					
				}else{
					//���͵���Ϣ
					//0.�ƶ�������Ϣ��0 , velocityX , velocityY 
					//1.��������������Ϣ:	1
					//2.̧������������Ϣ: 2
					//3.��������Ҽ�����Ϣ: 3
					//4.̧������Ҽ�����Ϣ: 4		
					int a = Integer.parseInt(content);//��ָ��ת�������α���,������ʾjava�İ汾ԭ������switch()����������д�ַ�������
					
					switch(a){
					case 1:
						rr.mousePress(InputEvent.BUTTON1_MASK);
						break;
					case 2:
						rr.mouseRelease(InputEvent.BUTTON1_MASK);
						break;
					case 3:
						rr.mousePress(InputEvent.BUTTON3_MASK);
						break;
					case 4:
						rr.mouseRelease(InputEvent.BUTTON3_MASK);
						break;
					}
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


