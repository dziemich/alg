package alg

import alg.findDuplicate
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DuplicateInSetTest{

  @Test
  fun finds3AsDuplicate(){
    val arr = arrayOf(3, 1, 2, 3);

    Assertions.assertEquals(3, findDuplicate(arr))
  }

  @Test
  fun finds2AsDuplicate(){
    val arr = arrayOf(2, 2, 3, 4, 1);

    Assertions.assertEquals(2, findDuplicate(arr))
  }
}
