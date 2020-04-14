package toolgood.words;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StopWatch;

import toolgood.words.IllegalWordsSearch;
import toolgood.words.IllegalWordsSearchResult;
import toolgood.words.StringSearch;
import toolgood.words.StringSearchEx;
import toolgood.words.WordsSearch;
import toolgood.words.WordsSearchEx;
import toolgood.words.WordsSearchResult;

public class DemoApplication {

	public static void main(String[] args) throws Exception {
		test_StringSearch();
		test_WordsSearch();

		test_StringSearchEx();
		test_WordsSearchEx();
		test_IllegalWordsSearch();

		test_pinyin();
		test_words();

		// try {
		// // test_save_load();
		// test_IllegalWordsSearch_loadWordsFormBinaryFile();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// test_times();
	}

	private static void test_StringSearch() {
		String test = "我是中国人";
		List<String> list = new ArrayList<String>();
		list.add("中国");
		list.add("国人");
		list.add("zg人");
		System.out.println("StringSearch run Test.");

		StringSearch iwords = new StringSearch();
		iwords.SetKeywords(list);

		boolean b = iwords.ContainsAny(test);
		if (b == false) {
			System.out.println("ContainsAny is Error.");
		}

		String f = iwords.FindFirst(test);
		if (f != "中国") {
			System.out.println("FindFirst is Error.");
		}

		List<String> all = iwords.FindAll(test);
		if (all.get(0) != "中国") {
			System.out.println("FindAll is Error.");
		}
		if (all.get(1) != "国人") {
			System.out.println("FindAll is Error.");
		}
		if (all.size() != 2) {
			System.out.println("FindAll is Error.");
		}

		String str = iwords.Replace(test, '*');
		if (str.equals("我是***") == false) {
			System.out.println("Replace is Error.");
		}
	}

	private static void test_StringSearchEx() {
		String test = "我是中国人";
		List<String> list = new ArrayList<String>();
		list.add("中国");
		list.add("国人");
		list.add("zg人");
		System.out.println("StringSearchEx run Test.");

		StringSearchEx iwords = new StringSearchEx();
		iwords.SetKeywords(list);

		boolean b = iwords.ContainsAny(test);
		if (b == false) {
			System.out.println("ContainsAny is Error.");
		}

		String f = iwords.FindFirst(test);
		if (f != "中国") {
			System.out.println("FindFirst is Error.");
		}

		List<String> all = iwords.FindAll(test);
		if (all.get(0) != "中国") {
			System.out.println("FindAll is Error.");
		}
		if (all.get(1) != "国人") {
			System.out.println("FindAll is Error.");
		}
		if (all.size() != 2) {
			System.out.println("FindAll is Error.");
		}

		String str = iwords.Replace(test, '*');
		if (str.equals("我是***") == false) {
			System.out.println("Replace is Error.");
		}
	}

	private static void test_WordsSearch() {
		String test = "我是中国人你是你是";
		List<String> list = new ArrayList<String>();
		list.add("中国");
		list.add("国人");
		list.add("zg人");
		System.out.println("WordsSearch run Test.");

		WordsSearch iwords = new WordsSearch();
		iwords.SetKeywords(list);

		boolean b = iwords.ContainsAny(test);
		if (b == false) {
			System.out.println("ContainsAny is Error.");
		}

		WordsSearchResult f = iwords.FindFirst(test);
		if (f.Keyword != "中国") {
			System.out.println("FindFirst is Error.");
		}

		List<WordsSearchResult> all = iwords.FindAll(test);
		if (all.get(0).Keyword != "中国") {
			System.out.println("FindAll is Error.");
		}
		if (all.get(1).Keyword != "国人") {
			System.out.println("FindAll is Error.");
		}
		if (all.size() != 2) {
			System.out.println("FindAll is Error.");
		}

		String str = iwords.Replace(test, '*');
		if (str.equals("我是***") == false) {
			System.out.println("Replace is Error.");
		}
	}

	private static void test_WordsSearchEx() {
		String test = "我是中国人";
		List<String> list = new ArrayList<String>();
		list.add("中国");
		list.add("国人");
		list.add("zg人");
		System.out.println("WordsSearchEx run Test.");

		WordsSearchEx iwords = new WordsSearchEx();
		iwords.SetKeywords(list);

		boolean b = iwords.ContainsAny(test);
		if (b == false) {
			System.out.println("ContainsAny is Error.");
		}

		WordsSearchResult f = iwords.FindFirst(test);
		if (f.Keyword != "中国") {
			System.out.println("FindFirst is Error.");
		}

		List<WordsSearchResult> all = iwords.FindAll(test);
		if (all.get(0).Keyword != "中国") {
			System.out.println("FindAll is Error.");
		}
		if (all.get(1).Keyword != "国人") {
			System.out.println("FindAll is Error.");
		}
		if (all.size() != 2) {
			System.out.println("FindAll is Error.");
		}

		String str = iwords.Replace(test, '*');
		if (str.equals("我是***") == false) {
			System.out.println("Replace is Error.");
		}
	}

	private static void test_IllegalWordsSearch() {
		String test = "我是中国人";
		List<String> list = new ArrayList<String>();
		list.add("中国");
		list.add("国人");
		list.add("zg人");
		System.out.println("IllegalWordsSearch run Test.");

		IllegalWordsSearch iwords = new IllegalWordsSearch();
		iwords.SetKeywords(list);

		boolean b = iwords.ContainsAny(test);
		if (b == false) {
			System.out.println("ContainsAny is Error.");
		}

		IllegalWordsSearchResult f = iwords.FindFirst(test);
		if (f.Keyword.equals("中国") == false) {
			System.out.println("FindFirst is Error.");
		}

		List<IllegalWordsSearchResult> all = iwords.FindAll(test);
		if (all.get(0).Keyword.equals("中国") == false) {
			System.out.println("FindAll is Error.");
		}
		if (all.get(1).Keyword.equals("国人") == false) {
			System.out.println("FindAll is Error.");
		}
		if (all.size() != 2) {
			System.out.println("FindAll is Error.");
		}

		String str = iwords.Replace(test, '*');
		if (str.equals("我是***") == false) {
			System.out.println("Replace is Error.");
		}
	}

	private static void test_save_load() throws IOException {
		String test = "我是中国人";
		List<String> list = new ArrayList<String>();
		list.add("中国");
		list.add("国人");
		list.add("zg人");
		System.out.println("test_save_load run Test.");

		StringSearchEx search = new StringSearchEx();
		search.SetKeywords(list);
		search.Save("1.dat");

		StringSearchEx iwords = new StringSearchEx();
		iwords.Load("1.dat");

		boolean b = iwords.ContainsAny(test);
		if (b == false) {
			System.out.println("ContainsAny is Error.");
		}

		String f = iwords.FindFirst(test);
		if (f != "中国") {
			System.out.println("FindFirst is Error.");
		}

		List<String> all = iwords.FindAll(test);
		if (all.get(0) != "中国") {
			System.out.println("FindAll is Error.");
		}
		if (all.get(1) != "国人") {
			System.out.println("FindAll is Error.");
		}
		if (all.size() != 2) {
			System.out.println("FindAll is Error.");
		}

		String str = iwords.Replace(test, '*');
		if (str.equals("我是***") == false) {
			System.out.println("Replace is Error.");
		}
	}

	private static void test_times() {
		String ts = readLineByLineJava8("BadWord.txt");
		String[] sp = ts.split("[\r\n]");
		List<String> list = new ArrayList<String>();
		for (String item : sp) {
			list.add(item);
		}
		String words = readLineByLineJava8("Talk.txt");

		StringSearchEx iwords = new StringSearchEx();
		iwords.SetKeywords(list);

		StopWatch sw = new StopWatch();
		sw.start("校验耗时");
		for (int i = 0; i < 100000; i++) {
			// iwords.ContainsAny(words);
			iwords.FindAll(words);
			// System.out.println(list2.size());
		}
		sw.stop();
		System.out.println(sw.getTotalTimeMillis() + "ms");

	}

	private static String readLineByLineJava8(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();
		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentBuilder.toString();
	}

	private static void test_IllegalWordsSearch_loadWordsFormBinaryFile() throws IOException {

		long l1 = System.currentTimeMillis();

		IllegalWordsSearch search = new IllegalWordsSearch();
		long l2 = System.currentTimeMillis();
		System.out.println("IllegalWordsSearch init time:" + (l2 - l1));

		search.Load(new ClassPathResource("IllegalWordsSearch.dat").getFile().getAbsolutePath());
		long l3 = System.currentTimeMillis();
		System.out.println("load Load time:" + (l3 - l2));

		String test = "卖毒品哈哈哈哈毛澤東porn哈哈哈哈胡锦涛pornasds哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛胡锦涛撒旦撒旦ｐｏｒｎporn哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn"
				+ "哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn哈哈哈哈胡錦濤porn哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn"
				+ "哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn"
				+ "哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn"
				+ "哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn"
				+ "哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn"
				+ "哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn";

		boolean b = search.ContainsAny(test);
		if (!b) {
			System.out.println("ContainsAny is Error.");
		}
		long l4 = System.currentTimeMillis();
		System.out.println("ContainsAny time:" + (l4 - l3));

		String str = search.Replace(test, '*');
		long l5 = System.currentTimeMillis();
		System.out.println("Replace Result:" + str);
		System.out.println("Replace time:" + (l5 - l4));
	}

	private static void test_IllegalWordsSearch_saveToBinaryFile() throws IOException {
		List<String> list = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new ClassPathResource("sensi_words.txt").getInputStream()))) {
			for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
				list.add(line);
			}
		}
		IllegalWordsSearch search = new IllegalWordsSearch();
		search.SetKeywords(list);
		search.Save("IllegalWordsSearch.dat");
	}

	private static void test_pinyin() throws NumberFormatException, IOException {
		System.out.println("text_pinyin run Test.");
		List<String> t = WordsHelper.GetAllPinYin('芃');
		if (t.get(0).equals("Peng") == false) {
			System.out.println("GetAllPinYin is Error.");
		}

		String a = WordsHelper.GetPinYinFast("阿");
		if (a.equals("A") == false) {
			System.out.println("GetPinYinFast is Error.");
		}

		String b = WordsHelper.GetPinYin("摩擦棒");
		if (b.equals("MoCaBang") == false) {
			System.out.println("GetPinYin is Error.");
		}
		b = WordsHelper.GetPinYin("秘鲁");
		if (b.equals("BiLu") == false) {
			System.out.println("GetPinYin is Error.");
		}

		String py = WordsHelper.GetPinYinFast("我爱中国");
		if (py.equals("WoAiZhongGuo") == false) {
			System.out.println("GetPinYinFast is Error.");
		}

		py = WordsHelper.GetPinYin("快乐，乐清");
		if (py.equals("KuaiLe，YueQing") == false) {
			System.out.println("GetPinYin is Error.");
		}

		py = WordsHelper.GetPinYin("快乐清理");
		if (py.equals("KuaiLeQingLi") == false) {
			System.out.println("GetPinYin is Error.");
		}

		py = WordsHelper.GetPinYin("我爱中国", true);
		if (py.equals("WǒÀiZhōngGuó") == false) {
			System.out.println("GetPinYin is Error.");
		}

		py = WordsHelper.GetFirstPinYin("我爱中国");
		if (py.equals("WAZG") == false) {
			System.out.println("GetPinYin is Error.");
		}

		List<String> pys = WordsHelper.GetAllPinYin('传');
		if (pys.get(0).equals("Chuan") == false) {
			System.out.println("GetAllPinYin is Error.");
		}
		if (pys.get(1).equals("Zhuan") == false) {
			System.out.println("GetAllPinYin is Error.");
		}

		py = WordsHelper.GetPinYinForName("单一一");
		if (py.equals("ShanYiYi") == false) {
			System.out.println("GetPinYinForName is Error.");
		}

		py = WordsHelper.GetPinYinForName("单一一", true);
		if (py.equals("ShànYīYī") == false) {
			System.out.println("GetPinYinForName is Error.");
		}

		List<String> all = WordsHelper.GetAllPinYin('石');
		if (all.size() == 0) {
			System.out.println("GetAllPinYin is Error.");
		}

	}

	private static void test_words() throws Exception {
		System.out.println("test_words run Test.");
		String s = WordsHelper.ToSimplifiedChinese("壹佰贰拾叁億肆仟伍佰陆拾柒萬捌仟玖佰零壹元壹角贰分");
		if (s.equals("壹佰贰拾叁亿肆仟伍佰陆拾柒万捌仟玖佰零壹元壹角贰分") == false) {
			System.out.println("ToSimplifiedChinese is Error.");
		}

		String tw = WordsHelper.ToTraditionalChinese("壹佰贰拾叁亿肆仟伍佰陆拾柒万捌仟玖佰零壹元壹角贰分");
		if (tw.equals("壹佰貳拾叄億肆仟伍佰陸拾柒萬捌仟玖佰零壹元壹角貳分") == false) {
			System.out.println("ToTraditionalChinese is Error.");
		}

		String tw2 = WordsHelper.ToTraditionalChinese("原代码11", 2);
		if (tw2.equals("原始碼11") == false) {
			System.out.println("ToTraditionalChinese is Error.");
		}

		String tw3 = WordsHelper.ToTraditionalChinese("反反复复", 2);
		if (tw3.equals("反反覆覆") == false) {
			System.out.println("ToTraditionalChinese is Error.");
		}
 
		String tw4 = WordsHelper.ToTraditionalChinese("这人考虑事情总是反反复复的", 2);
		if (tw4.equals("這人考慮事情總是反反覆覆的") == false) {
			System.out.println("ToTraditionalChinese is Error.");
		}


	}
}
