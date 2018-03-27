package DAO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

import com.game.bomberman.model.Score;

public class ScoreDAO {

	ArrayList<Score> dataScore;
	ArrayList<Score> topScore;
	BufferedReader buffReader;
	PrintWriter printWriter;
	StringTokenizer sToken;

	public ScoreDAO() {
		dataScore = new ArrayList<>();
		loadDataScore();
		sortHighScore();
		writeScore();

	}

	public ArrayList<Score> getDataScore() {
		return dataScore;
	}

	public void setDataScore(ArrayList<Score> dataScore) {
		this.dataScore = dataScore;
	}

	public void writeScore() {
		try {
			printWriter = new PrintWriter(
					new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("d://highscore.score"))),true);
			for (int i = 0; i < 10; i++) {
				
				printWriter.println(dataScore.get(i).getName()+"\t"+dataScore.get(i).getScore());
			} 
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadDataScore() {
		try {
			buffReader = new BufferedReader(new InputStreamReader(
					new BufferedInputStream(new FileInputStream("d://highscore.score")), "UTF-8"));
			String line;
			while ((line = buffReader.readLine()) != null) {
				sToken = new StringTokenizer(line, "\t");
				dataScore.add(new Score(sToken.nextToken(), Integer.parseInt(sToken.nextToken())));
			}
			buffReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean addHighScore(Score score) {
		return dataScore.add(score);
	}

	public void sortHighScore() {
		// Sorting
		Collections.sort(dataScore, new Comparator<Score>() {
			@Override
			public int compare(Score score1, Score score2) {

				return score2.getScore() - score1.getScore();
			}
		});

	}

	public static void main(String[] args) {
		new ScoreDAO();
	}

}
