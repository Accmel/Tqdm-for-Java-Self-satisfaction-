package test;

import boot.Tqdm;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		Tqdm tqdm = new Tqdm(200);
		for(int i=0; i<200; i++) {
			tqdm.tqdm();
			Thread.sleep(50);
		}

	}

}
