package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Signs {

	int lifeCount = 3;
	
	

	public void showlifeSign(GraphicsContext gc, int lifeCount) {
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.RED);
		gc.setFont(new Font("Arial Black", 25));
		gc.setLineWidth(1);
		String text2 = "Lifes: " + lifeCount;
		int textx2 = 300;
		int texty2 = 50;
		gc.fillText(text2, textx2, texty2);
		gc.strokeText(text2, textx2, texty2);
	}

	public void showStageCount(GraphicsContext gc, int stage) {
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.RED);
		gc.setFont(new Font("Arial Black", 30));
		gc.setLineWidth(1);
		String text1 = "Stage: " + stage;
		int textx1 = 50;
		int texty1 = 50;
		gc.fillText(text1, textx1, texty1);
		gc.strokeText(text1, textx1, texty1);
	}

	public void showScoreOnScreen(GraphicsContext gc, int score) {
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.RED);
		gc.setFont(new Font("Arial Black", 30));
		gc.setLineWidth(1);
		String text = "Score: " + score;
		int textx = 550;
		int texty = 50;
		gc.fillText(text, textx, texty);
		gc.strokeText(text, textx, texty);
	}

	public void showClickForRestart(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.RED);
		gc.setFont(new Font("Arial Black", 30));
		gc.setLineWidth(1);
		String text = "- CLICK - FOR - RETRY -";
		int textx = 300;
		int texty = 100;
		gc.fillText(text, textx, texty);
		gc.strokeText(text, textx, texty);

	}

	public void showGameOverAndScore(GraphicsContext gc, int score, int stage) {
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.RED);
		gc.setFont(new Font("Arial Black", 48));
		gc.setLineWidth(2);
		String text = "GAME OVER - Score: " + score;
		int textx = 50;
		int texty = 300;
		gc.fillText(text, textx, texty);
		gc.strokeText(text, textx, texty);

		gc.setFill(Color.WHITE);
		gc.setStroke(Color.RED);
		gc.setFont(new Font("Arial Black", 30));
		gc.setLineWidth(2);
		String text1 = "Stage: " + stage;
		int textx1 = 300;
		int texty1 = 350;
		gc.fillText(text1, textx1, texty1);
		gc.strokeText(text1, textx1, texty1);
	}

	public void showYouWinAndScore(GraphicsContext gc, int score, int stage) {
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.RED);
		gc.setFont(new Font("Arial Black", 48));
		gc.setLineWidth(2);
		String text = "YOU WIN - Stage: " + (stage -1);
		int textx = 50;
		int texty = 300;
		gc.fillText(text, textx, texty);
		gc.strokeText(text, textx, texty);

		gc.setFill(Color.WHITE);
		gc.setStroke(Color.RED);
		gc.setFont(new Font("Arial Black", 30));
		gc.setLineWidth(2);
		String text1 = "Score: " + score;
		int textx1 = 300;
		int texty1 = 350;
		gc.fillText(text1, textx1, texty1);
		gc.strokeText(text1, textx1, texty1);
	}

}
