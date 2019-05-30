package app;

public class Application {

	public static void main(String[] args) {
		GameController controller = new GameController();
		try {
			controller.mainLoop();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
