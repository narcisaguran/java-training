package clean.code.chess.requirements;

import clean.code.chess.requirements.Pawn;
import clean.code.chess.requirements.PieceColor;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    public final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_HEIGHT+1][MAX_BOARD_WIDTH+1];
    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if(IsLegalBoardPosition(xCoordinate,yCoordinate) && IsValidRow(xCoordinate,pieceColor)){
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pawn.setPieceColor(pieceColor);
            pawn.setChessBoard(this);
            this.pieces[xCoordinate][yCoordinate] = pawn;

        }
//        else pieces[MAX_BOARD_HEIGHT][MAX_BOARD_WIDTH] = pawn;
    }

    //pawn can only move one position up, if it is not capturing
    public void Update(Pawn pawn) {
        if(IsLegalBoardPosition(pawn.getXCoordinate()+1, pawn.getYCoordinate())){
            int xNew = pawn.getXCoordinate()+1;
            int yNew = pawn.getYCoordinate();

            pawn.setXCoordinate(xNew);
            pawn.setYCoordinate(yNew);

            if(pawn.getPieceColor().equals(PieceColor.BLACK)) pawn.setPieceColor(PieceColor.WHITE);
            else pawn.setPieceColor(PieceColor.BLACK);

            pawn.setChessBoard(this);

            this.pieces[xNew][yNew] = pawn;

            this.pieces[xNew - 1][yNew] = null;
        }
    }

    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return (xCoordinate>=0&&xCoordinate<=MAX_BOARD_HEIGHT)&&(yCoordinate>=0&&yCoordinate<=MAX_BOARD_WIDTH)&&this.pieces[xCoordinate][yCoordinate] == null;
    }

    public boolean IsValidRow(int xCoordinate, PieceColor color) {
        if (color == PieceColor.WHITE) {
            return xCoordinate == 0 || xCoordinate == 1;
        }
        return xCoordinate == MAX_BOARD_HEIGHT - 1 || xCoordinate == MAX_BOARD_HEIGHT;
    }


}
