package alg

import java.util.Collections

/*
https://www.hackerrank.com/challenges/password-cracker/problem
 */

fun passwordCracker2(passwords: Array<String>, loginAttempt: String): String {
  val base = mutableListOf<String>()
  val res = mutableListOf<String>()

  create(base, loginAttempt, passwords, res)

  return if (res.size > 0) res[0] else "WRONG PASSWORD"
}


fun create(base: MutableList<String>, loginAttempt: String, passwords: Array<String>, res: MutableList<String>){
  if (base.joinToString(separator = "") == loginAttempt){
    res.add(base.joinToString(separator = " "));
    return
  }
  for (pass in passwords){
    val copy = base.toMutableList()
    copy.add(pass)

    if(copy.joinToString("").length <= loginAttempt.length){
      create(copy, loginAttempt, passwords, res);
    }
  }
}


fun passwordCracker(passwords: Array<String>, loginAttempt: String): String {
  val r = findFromSubstring(passwords, loginAttempt, mutableListOf());
  val result = r.joinToString(separator = "")
  return if(result != loginAttempt) "WRONG PASSWORD" else r.joinToString(separator = " ")
}

fun findFromSubstring(passwords: Array<String>, word: String, list: MutableList<String>): MutableList<String> {
  if(word.isEmpty()) return list;
  for(pass in passwords) {
    val ind = word.indexOf(pass)
    if(ind == 0){
      val copy = list.toMutableList()
      copy.add(pass)
      return findFromSubstring(passwords, word.substring(pass.length), copy)
    }
  }
  return mutableListOf()
}
