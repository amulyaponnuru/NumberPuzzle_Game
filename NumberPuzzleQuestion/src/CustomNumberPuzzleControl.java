import java.awt.*;
import java.util.ArrayList;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}

	public int getHeight() {
		return 250;
	}

	public int getXPosition() {
		return 200;
	}

	public int getYPosition() {
		return 200;
	}

	public String getTitle() {
		return "Number Puzzle";
	}

	public int getShuffleButtonFontSize() {
		return 12;
	}

	public int getNumbersFontSize() {
		return 12;
	}

	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}

	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game) {
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		int buttonClickedId = emptyCellId;

		// Your logic here
		// swapButton(buttons[emptyCellId],buttonClicked);
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] == buttonClicked) {
				buttonClickedId = i;
				break;
			}
		}
		if (emptyCellId == 5 || emptyCellId == 6 || emptyCellId == 9 || emptyCellId == 10) {
			if (buttonClickedId == emptyCellId + 4 || buttonClickedId == emptyCellId - 4
					|| buttonClickedId == emptyCellId + 1 || buttonClickedId == emptyCellId - 1) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId = buttonClickedId;
			}
		} else if (emptyCellId == 4 || emptyCellId == 8) {
			if (buttonClickedId == emptyCellId + 4 || buttonClickedId == emptyCellId - 4
					|| buttonClickedId == emptyCellId + 1) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId = buttonClickedId;
			}
		} else if (emptyCellId == 1 || emptyCellId == 2) {
			if (buttonClickedId == emptyCellId + 4 || buttonClickedId == emptyCellId - 1
					|| buttonClickedId == emptyCellId + 1) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId = buttonClickedId;
			}
		} else if (emptyCellId == 7 || emptyCellId == 11) {
			if (buttonClickedId == emptyCellId + 4 || buttonClickedId == emptyCellId - 4
					|| buttonClickedId == emptyCellId - 1) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId = buttonClickedId;
			}
		} else if (emptyCellId == 13 || emptyCellId == 14) {
			if (buttonClickedId == emptyCellId - 4 || buttonClickedId == emptyCellId - 1
					|| buttonClickedId == emptyCellId + 1) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId = buttonClickedId;
			}
		} else if (emptyCellId == 0) {
			if (buttonClickedId == 1 || buttonClickedId == 4) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId = buttonClickedId;
			}
		} else if (emptyCellId == 3) {
			if (buttonClickedId == 2 || buttonClickedId == 7) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId = buttonClickedId;
			}
		} else if (emptyCellId == 12) {
			if (buttonClickedId == 8 || buttonClickedId == 13) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId = buttonClickedId;
			}
		} else {
			if (buttonClickedId == 11 || buttonClickedId == 14) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId = buttonClickedId;
			}
		}
		System.out.println(emptyCellId);
		return emptyCellId;
	}

	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		// Your logic here
		ArrayList<Integer> list = new ArrayList<Integer>(15);
		for (int i = 1; i <= 15; i++) {
			list.add(i);
		}
		for (int i = 0; i < 15; i++) {
			int a = getRandomNumber();
			int randNum = (int) ((a / 100.00) * list.size());
			arr[i] = list.remove(randNum);
		}

		return arr;
	}

	public boolean checkForWinner(Button[] buttons) {
		boolean winner = true;

		// Your Logic here
		// Checking if the array is sorted
		int[] arr = getIntegerArrayOfButtonIds(buttons);
		for (int i = 1; i <= 15; i++) {
			if (arr[i - 1] != i) {
				winner = false;
			}
		}

		return winner;
	}
}

//Programming essentials
//Thinking in objects
//database essentials
//web fundamentals, html css, javascript