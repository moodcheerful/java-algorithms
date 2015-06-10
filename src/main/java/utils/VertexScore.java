package utils;

public class VertexScore {

	private final int vertex;
	private int score;

	public VertexScore(int vertex, int score) {
		this.vertex = vertex;
		this.score = score;
	}

	public int getVertex() {
		return vertex;
	}

	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return "(" + vertex + ", " + score + ")";
	}
}