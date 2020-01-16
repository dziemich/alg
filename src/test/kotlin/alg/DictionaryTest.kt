package alg

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DictionaryTest {
  @Test
  fun verifiesDiffers(): Unit {
    Assertions.assertEquals(0, "aaa".differs("aaa"))
    Assertions.assertEquals(1, "aaaa".differs("aaab"))
    Assertions.assertEquals(2, "aaaa".differs("aabb"))
  }

  @Test
  fun verifiesMatches(): Unit {
    Assertions.assertTrue("aaa".matches("aab"));
    Assertions.assertFalse("aaa".matches("acb"));
  }

  @Test
  fun verifiesFindPathCorrectFind(): Unit {
    val dictionary = listOf("dot", "dop", "dat", "cat")
    val result = mutableListOf("dog", "dot", "dat", "cat")
    val p = prep("dog", "cat", dictionary)
    Assertions.assertIterableEquals(result, p)
  }

  @Test
  fun verifiesFindPathIncorrectFind(): Unit {
    val dictionary = listOf("dot", "tod", "dat", "dar")
    val prep = prep("dog", "cat", dictionary)
    Assertions.assertIterableEquals(mutableListOf<String>(), prep)
  }

  @Test
  fun verifiesDirectPath(): Unit {
    val dictionary = listOf("dot", "tod", "dat", "cog")
    val prep = prep("dog", "cog", dictionary)
    prep.forEach { println(it) }
    Assertions.assertIterableEquals(mutableListOf("dog", "cog"), prep)
  }

  @Test
  fun verifiesBackwardsPath(): Unit {
    val dictionary = listOf("cat", "cad", "ced", "ceg", "cog")
    val result = mutableListOf("dog", "cog", "ceg", "ced", "cad", "cat")
    val prep = prep("dog", "cat", dictionary)
    prep.forEach { println(it) }
    Assertions.assertIterableEquals(result, prep)
  }
}

