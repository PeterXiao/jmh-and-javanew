/**
 *
 */
package codesimiliar;

import info.debatty.java.stringsimilarity.Damerau;
import info.debatty.java.stringsimilarity.JaroWinkler;
/**
 * @author LiY
 * @time 上午10:47:56
 */
import info.debatty.java.stringsimilarity.Levenshtein;
import info.debatty.java.stringsimilarity.LongestCommonSubsequence;
import info.debatty.java.stringsimilarity.NGram;
import info.debatty.java.stringsimilarity.NormalizedLevenshtein;
import info.debatty.java.stringsimilarity.OptimalStringAlignment;
import info.debatty.java.stringsimilarity.WeightedLevenshtein;

public class MyApp {

	public static void main(String[] args) {
		final Levenshtein l = new Levenshtein();

		System.out.println(l.distance("My string", "My $tring"));
		System.out.println(l.distance("My string", "My $tring"));
		System.out.println(l.distance("My string", "My $tring"));

		final NormalizedLevenshtein s = new NormalizedLevenshtein();

		System.out.println(s.distance("My string", "My $tring"));
		System.out.println(s.distance("My string", "My $tring"));
		System.out.println(s.distance("My string", "My $tring"));
		final WeightedLevenshtein wl = new WeightedLevenshtein((c1, c2) -> {

			// The cost for substituting 't' and 'r' is considered
			// smaller as these 2 are located next to each other
			// on a keyboard
			if (c1 == 't' && c2 == 'r') {
				return 0.5;
			}

			// For most cases, the cost of substituting 2 characters
			// is 1.0
			return 1.0;
		});

		System.out.println(wl.distance("String1", "Srring2"));

		final Damerau d = new Damerau();

		// 1 substitution
		System.out.println(d.distance("ABCDEF", "ABDCEF"));

		// 2 substitutions
		System.out.println(d.distance("ABCDEF", "BACDFE"));

		// 1 deletion
		System.out.println(d.distance("ABCDEF", "ABCDE"));
		System.out.println(d.distance("ABCDEF", "BCDEF"));
		System.out.println(d.distance("ABCDEF", "ABCGDEF"));

		// All different
		System.out.println(d.distance("ABCDEF", "POIU"));

		final OptimalStringAlignment osa = new OptimalStringAlignment();

		System.out.println(osa.distance("CA", "ABC"));

		final JaroWinkler jw = new JaroWinkler();

		// substitution of s and t
		System.out.println(jw.similarity("My string", "My tsring"));

		// substitution of s and n
		System.out.println(jw.similarity("My string", "My ntrisg"));

		final LongestCommonSubsequence lcs = new LongestCommonSubsequence();

		// Will produce 4.0
		System.out.println(lcs.distance("AGCAT", "GAC"));

		// Will produce 1.0
		System.out.println(lcs.distance("AGCAT", "AGCT"));

		final info.debatty.java.stringsimilarity.MetricLCS lcs1 = new info.debatty.java.stringsimilarity.MetricLCS();

		final String s1 = "ABCDEFG";
		final String s2 = "ABCDEFHJKL";
		// LCS: ABCDEF => length = 6
		// longest = s2 => length = 10
		// => 1 - 6/10 = 0.4
		System.out.println(lcs1.distance(s1, s2));

		// LCS: ABDF => length = 4
		// longest = ABDEF => length = 5
		// => 1 - 4 / 5 = 0.2
		System.out.println(lcs1.distance("ABDEF", "ABDIF"));

		// produces 0.416666
		final NGram twogram = new NGram(2);
		System.out.println(twogram.distance("ABCD", "ABTUIO"));

		// produces 0.97222
		final String s11 = "Adobe CreativeSuite 5 Master Collection from cheap 4zp";
		final String s21 = "Adobe CreativeSuite 5 Master Collection from cheap d1x";
		final NGram ngram = new NGram(4);
		System.out.println(ngram.distance(s11, s21));
	}
}
