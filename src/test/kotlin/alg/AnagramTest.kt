package alg

import alg.verifyCaseInsensitive
import alg.verifyCaseSensitive
import alg.verifySentences
import alg.verifySentencesWordByWord
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AnagramTest {

  @Test
  fun verifiesCaseSensitiveWordsCorrectly() {
    Assertions.assertFalse(verifyCaseSensitive("alg.findPath", "b"))
    Assertions.assertFalse(verifyCaseSensitive("aab", "ab"))
    Assertions.assertFalse(verifyCaseSensitive("aab", "abbb"))

    Assertions.assertTrue(verifyCaseSensitive("ab", "ab"))
    Assertions.assertTrue(verifyCaseSensitive("ba", "ab"))
  }

  @Test
  fun verifiesCaseInensitiveWordsCorrectly() {
    Assertions.assertTrue(verifyCaseInsensitive("aB", "Ab"))
    Assertions.assertFalse(verifyCaseInsensitive("BBa", "ab"))
    Assertions.assertTrue(verifyCaseInsensitive("BBa", "abb"))
  }

  @Test
  fun verifiesSentencesCorrectly(){
    Assertions.assertTrue(verifySentences("wesoly misiek", "misiek wesoly"))
    Assertions.assertTrue(verifySentences("wesoly, misiek.", "misiek wesoly"))
  }

  @Test
  fun verifiesSentencesWordByWord(){
    Assertions.assertFalse(verifySentencesWordByWord("dcba bdbd caaa bbb", "abcd ddbb aaca"))
    Assertions.assertFalse(
      verifySentencesWordByWord(
        "dcba bdbd caaa bbb",
        "abcd ddbb aaca ccc"
      )
    )
    Assertions.assertTrue(verifySentencesWordByWord("dcba bdbd caaa", "abcd ddbb aaca"))
  }
}
