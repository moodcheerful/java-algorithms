package algorithms;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/*
 * PageRank - the random surfer model and a Markov chain algorithm.
 * 
 * According to Google: PageRank works by counting the number and quality of links 
 * to a page to determine a rough estimate of how important the website is. 
 * The underlying assumption is that more important websites are likely to receive 
 * more links from other websites.
 * 
 * Input:
 * N is a fixed set of webpages.
 * M is a number of iterations (the random surfer's moves).
 * 
 * pageLinks is a list of ordered pairs of integers (the representations of all the links).
 * 
 * The damping factor ALPHA, set to 0.85: 
 * We assume that 85% of the time the random surfer clicks 
 * a random link on the current page (each link chosen with equal probability) 
 * and that 15% of the time the random surfer goes directly to a random page 
 * (with equal probability).
 * 
 * The N x N transition matrix completely specifies the behavior of the random surfer:
 * transitionMatrix[i][j] = probability that the random surfer moves from page i to page j.
 *  
 * If a page has no outlinks, we make the page equally likely to transition to every other page,
 * to make the transition matrix stochastic (all rows sum to 1).
 * 
 * The page's rank is the probability that a random surfer ends up on the page. 
 * PageRank is computed by dividing the number of times that the surfer visits each page 
 * by the number of the surfer's moves.
 * 
 * Markov chain is a random process that undergoes transitions from one state to another 
 * on a state space N.
 * 
 * The Markov property ("memorylessness"):
 * The probability distribution of the next state depends only on the current state and 
 * not on the sequence of events that preceded it. 
 * 
 * Markov chain mixing:
 * The surfer could start anywhere, because the probability that he eventually ends up 
 * on any particular page is the same for all starting pages.
 * 
 * Markov chain convergence:
 * No matter where the surfer starts, the process eventually stabilizes to a point 
 * where further surfing provides no further information. 
 * 
 * Question: How many iterations M until convergence to within a tolerable limit? 
 * Brin and Page reported that only 50-100 iterations M are needed 
 * (see JUnit test results).
 * 
 * Time Complexity is O(N^2), 
 * since the algorithm runs M vector-matrix multiplications, where in practice M < 100.
 * 
 * Possible modifications:
 * 1. Change the leap probability ALPHA to 0.80, 0.90, 0.95.
 * 2. Ignore multiple links (count them as one link).
 *  
 */
public class MarkovChainPageRank {

	// number of pages:
	private int N;
	// list of all links (i, j) from page i to page j:
	private List<List<Integer>> pageLinks;

	// linkCounts[i][j] = number of links from page i to page j:
	private int[][] linkCounts;
	// outDegree[i] = number of links from page i to anywhere:
	private int[] outDegree;
	// transitionMatrix[i][j] = probability that surfer moves from page i to
	// page j:
	private double[][] transitionMatrix;

	// the leap probability parameter:
	private final static double ALPHA = 0.85;

	public MarkovChainPageRank(int N, List<List<Integer>> pageLinks) {

		this.N = N;
		this.pageLinks = pageLinks;
		this.linkCounts = new int[N][N];
		this.outDegree = new int[N];
		this.transitionMatrix = new double[N][N];

		computeLinkCounts();
		computeTransitionMatrix();
	}

	// compute number of links from each page:
	public void computeLinkCounts() {

		for (List<Integer> el : pageLinks) {

			linkCounts[el.get(0)][el.get(1)]++;
			outDegree[el.get(0)]++;
		}
	}

	// compute probabilities that the surfer moves from page i to page j:
	public void computeTransitionMatrix() {
		double p;
		// compute probability distribution for row i:
		for (int i = 0; i < N; i++) {
			// compute probability for column j:
			for (int j = 0; j < N; j++) {

				if (outDegree[i] != 0) {

					p = ALPHA * linkCounts[i][j] / outDegree[i]
							+ (1 - ALPHA) / N;

				} else { // no outgoing links
					p = 1.0 / N;
				}
				transitionMatrix[i][j] = p;
			}
		}
	}

	// compute pageRank (probability that the random surfer visits the page),
	// given the number of moves M the random surfer makes:
	public double[] randomSurfer(int M) {

		// frequency[i] = number of times surfer hits page i:
		int[] frequency = new int[N];
		// page ranks array:
		double[] pageRank = new double[N];
		// start at page 0:
		int currentPage = 0;

		// move the random surfer M number of times:
		for (int i = 0; i < M; i++) {

			// make the next random page selection from a discrete probability
			// distribution transitionMatrix[currentPage][]
			double random = Math.random();
			double sum = 0.0;

			for (int j = 0; j < N; j++) {

				// find interval containing random:
				sum = sum + transitionMatrix[currentPage][j];

				if (random < sum) {
					// select the next page j:
					currentPage = j;
					break;
				}
			}
			// increment frequency of the visited page:
			frequency[currentPage]++;
		}

		// compute page ranks:
		for (int i = 0; i < N; i++) {
			pageRank[i] = (double) frequency[i] / M;
		}
		return pageRank;
	}

	// compute pageRank using Markov Chain vector-matrix multiplication,
	// given the number of iterations M;
	// time complexity is O(M*N^2)
	public double[] markovChain(int M) {

		// use the Power Method to compute page ranks:
		double[] pageRank = new double[N];
		pageRank[0] = 1.0;

		for (int i = 0; i < M; i++) {

			// compute effect of next move on page ranks:
			double[] newRank = new double[N];

			for (int j = 0; j < N; j++) {
				// new rank of page j is the dot product of old ranks (pageRank[])
				// and column j of transitionMatrix[][j]:
				for (int k = 0; k < N; k++) {

					newRank[j] = newRank[j]
							+ pageRank[k] * transitionMatrix[k][j];
				}
			}

			// update page ranks:
			pageRank = newRank;
		}
		return pageRank;
	}

	// return a string representation of double[] array accurate to
	// 2 decimal places:
	public String printArray(double[] array) {

		StringBuilder sb = new StringBuilder();
		sb.append('[');

		DecimalFormat formatter = new DecimalFormat("0.00");

		for (int i = 0; i < N - 1; i++) {
			sb.append(formatter.format(array[i])).append(", ");
		}
		sb.append(formatter.format(array[N - 1])).append(']');
		return sb.toString();
	}

	// return a string representation of double[][] matrix accurate to
	// 2 decimal places:
	public String printMatrix(double[][] matrix) {

		StringBuilder sb = new StringBuilder();
		String NEWLINE = System.lineSeparator();
		sb.append(NEWLINE);

		DecimalFormat formatter = new DecimalFormat("0.00");

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				sb.append(formatter.format(matrix[i][j])).append(", ");
			}
			sb.append(formatter.format(matrix[i][N - 1])).append(NEWLINE);
		}
		return sb.toString();
	}

	// return a string representation of int[][] matrix:
	public String printMatrix(int[][] matrix) {

		StringBuilder sb = new StringBuilder();
		String NEWLINE = System.lineSeparator();
		sb.append(NEWLINE);

		for (int i = 0; i < N; i++) {
			sb.append(Arrays.toString(matrix[i])).append(NEWLINE);
		}
		return sb.toString();
	}

	public int[][] getLinkCounts() {
		return linkCounts;
	}

	public int[] getOutDegree() {
		return outDegree;
	}

	public double[][] getTransitionMatrix() {
		return transitionMatrix;
	}
}
