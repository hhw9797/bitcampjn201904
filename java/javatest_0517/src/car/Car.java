package car;

class Box {
	public void wrap() {
		System.out.println("simple wrap");
	}

	public void main(String[] args) {
		Box box = new Box();
		PaperBox paperbox = new PaperBox();
		GoldPaperBox goldpaperbox = new GoldPaperBox();

		wrapBox(box);
		wrapBox(paperbox);
		wrapBox(goldpaperbox);
	}

	public static void wrapBox(Box box) {
		box.wrap();
	}
}

class PaperBox extends Box {
	public void paperWrap() {
		System.out.println("Paper Wrap");
	}
}

class GoldPaperBox extends PaperBox {
	public void goldWrap() {
		System.out.println("Gold Wrap");
	}

}
