//package alg
//
///*
//https://www.hackerrank.com/challenges/simplified-chess-engine/problem
// */
//
//fun simplifiedChessEngine(
//  whites: Array<Array<Char>>,
//  blacks: Array<Array<Char>>,
//  moves: Int
//): String {
//
//  turn("W", 0, moves)
//
//}
//
//
//fun turn(
//  color: String,
//  boardState: BoardState,
//  move: Int,
//  moveLimit: Int
//): BoardState {
//  if (move >= moveLimit) {
//    return boardState;
//  } else {
//    if (color == "W") {
//      for (piece in boardState.whites) {
//        piece.makeMove()
//      }
//    }
//    makeMove()
//  }
//}
//
//
//data class BoardState(
//  val whites: Array<Piece>,
//  val blacks: Array<Piece>
//)
//
//
//interface Piece {
//  val pos1: String
//  val pos2: String
//}
//
//class Rook(override val pos1: String, override val pos2: String) : Piece
//class Bishop(override val pos1: String, override val pos2: String) : Piece
//class Knight(override val pos1: String, override val pos2: String) : Piece
//class Queen(override val pos1: String, override val pos2: String) : Piece
//
//fun Piece.makeMove(boardState: BoardState, color: String){
//  when(this){
//    is Rook -> {
//
//    }
//    is Bishop ->
//    is Knight ->
//    is Queen ->
//  }
//}
//
