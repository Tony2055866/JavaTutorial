package concurrent;

public class VolatileTest {
    public static volatile int race = 0;

	public static  void increase(){
        ++race;
	}
	
	private static final int THREADS_COUNT = 20;
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[ THREADS_COUNT ];
		for(int i=0; i<THREADS_COUNT; i++){
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0; j<10000; j++)
						increase();
				}
			});
			threads[i].start();
		}
        for(int i=0; i<THREADS_COUNT; i++){
            threads[i].join();
        }

		System.out.println(race);
	}
}