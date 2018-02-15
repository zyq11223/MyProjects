package Gift;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gift{
	
	
	public void wrongAnswer(String str) {
		
		JOptionPane.showMessageDialog(null, str,"回答错误！",JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void PartOne()
	{
		JOptionPane.showMessageDialog(null, "嘿～你好呀！","Hi～",JOptionPane.INFORMATION_MESSAGE);
		String name = JOptionPane.showInputDialog(null, "我是王子旭，你是？","你好～",JOptionPane.INFORMATION_MESSAGE);
		while(!name.equals("女朋友"))
		{
			if (name.equals("你爸爸")||name.equals("爸爸")||name.equals("father")||name.equals("your father")) {
				wrongAnswer("我是你爸爸！");
			}else {
				wrongAnswer("不对不对～我要的不是你");
			}
			name = JOptionPane.showInputDialog(null, "我是男朋友，你是：");
		}
		
		JOptionPane.showMessageDialog(null, "啊～太好了！\n我想找的就是你啊～");
		JOptionPane.showMessageDialog(null, "emmmmm......\n今天是一个好日子～");
		JOptionPane.showMessageDialog(null, "今天是我们在一起的第909天！","Wow！",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "而且今天还不太一样！！","emmmmm...",JOptionPane.INFORMATION_MESSAGE);
		Object[] options =  {"七夕节","情人节","爱人节","牛郎节"};
		int chosen = JOptionPane.showOptionDialog(null, "今天是个什么日子呢？", "猜一猜啊猜一猜", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		while (chosen!=1) {
			wrongAnswer("不对！\n(你怎么这么蠢呢)");
			 chosen = JOptionPane.showOptionDialog(null, "今天是个什么日子呢？", "猜一猜啊猜一猜", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);			
		}
		
		
		Object[] options2 =  {"对啊","不啊","随便"};
		int chosen2 = JOptionPane.showOptionDialog(null, "所以，今天要出去玩对不对啊～", "我要约你了！", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
		if (chosen2!=0) {
			wrongAnswer("55555555555\n我伤心了");
			System.exit(0);
		}
			
		Object[] options3 ={ "王品！", "看电影！", "逛街！", "烤鱼！", "只要和你在一块，什么都可以～" };  
		String chosen3 = (String) JOptionPane.showInputDialog(null,"那么...你选一个吧:\n", "选一个吧", JOptionPane.PLAIN_MESSAGE, null, options3, options3[0]);	
		while (!chosen3.equals("只要和你在一块，什么都可以～")) {
			wrongAnswer("什么什么？我没听见啊...");
			chosen3 = (String) JOptionPane.showInputDialog(null,"请选择你的爱好:\n", "爱好", JOptionPane.PLAIN_MESSAGE, null, options3, options3[0]);	

		}

		Object[] options4 ={ "好啊！", "一边去！" };  
		int chosen4 = JOptionPane.showOptionDialog(null, "那么...我可以约你吗？", "约会咯",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options4, options4[0]);  
		if(chosen4!=0) {
			wrongAnswer("哼！");
			System.exit(0);
		}
		JOptionPane.showMessageDialog(null, "那你就来找我呗～\n   mua");
	}

	
	
	
	public static void main(String[] args) {
		new Gift().PartOne();
	}

}
