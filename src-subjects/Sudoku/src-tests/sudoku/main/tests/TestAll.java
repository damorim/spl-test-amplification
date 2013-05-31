package sudoku.main.tests;

import java.io.File;

import sudoku.main.Structure;
import sudoku.main.SudokuFacade;

public class TestAll {

	public static final int numberOfTests = 4;

	public static void main(String[] args) {
//		runTest(1);
//		runTest(2);
//		runTest(3);
//		runTest(4);
//		runTest(5);
	}

	/**
	 * Run each test according to the number.
	 */
	public static void runTest(int test) {
		// running tests with the input
		switch (test) {
		case 1:
			test1();
			break;
		case 2:
			test2();
			break;
		case 3:
			test3();
			break;
		case 4:
			test4();
			break;
		case 5:
			test5();
			break;
		default:
			throw new RuntimeException("This test does not exist");
		}
	}

	public static void test5() {
		// #if BASE && SOLVER && STATES && UNDO
		SudokuFacade sf = new SudokuFacade();
		sf.loadFile(new File("../Sudoku/src-tests/inputTest1.txt"));
		sf.solutionHint();
		sf.SaveState(new File("../Sudoku/src-tests/state1.txt"));
		sf.LoadState(new File("../Sudoku/src-tests/state1.txt"));

		sf.setPossibilities(16);
		sf.setField(Structure.BOX, 2, 4, 1);
		sf.setField(Structure.BOX, 1, 2, 4);
		sf.setField(Structure.BOX, 0, 0, 1);
		sf.setField(Structure.BOX, 3, 3, 3);

		sf.setField(Structure.BOX, 2, 4, 1);
		sf.setField(Structure.BOX, 1, 2, 4);
		sf.undo();
		sf.setField(Structure.BOX, 0, 0, 1);
		sf.undo();

		sf.GenerateSudoku();

		System.out.println("test5");
		// #endif
	}

	public static void test1() {
		// #if BASE && SOLVER && STATES && UNDO
		SudokuFacade sf = new SudokuFacade();
		sf.loadFile(new File("../Sudoku/src-tests/inputTest1.txt"));
		sf.solutionHint();
		sf.SaveState(new File("../Sudoku/src-tests/state1.txt"));
		sf.LoadState(new File("../Sudoku/src-tests/state1.txt"));
		System.out.println("test1");
		// #endif
	}

	public static void test2() {
		// #if BASE && EXTENDED_SUDOKU && SOLVER
		SudokuFacade sf = new SudokuFacade();
		sf.setPossibilities(16);
		sf.setField(Structure.BOX, 2, 4, 1);
		sf.setField(Structure.BOX, 1, 2, 4);
		sf.setField(Structure.BOX, 0, 0, 1);
		sf.setField(Structure.BOX, 3, 3, 3);
		System.out.println("test2");
		// #endif
	}

	public static void test3() {
		// #if BASE && UNDO && SOLVER && STATES
		SudokuFacade sf = new SudokuFacade();
		sf.setField(Structure.BOX, 2, 4, 1);
		sf.setField(Structure.BOX, 1, 2, 4);
		sf.undo();
		sf.setField(Structure.BOX, 0, 0, 1);
		sf.undo();
		System.out.println("test3");
		// #endif
	}

	public static void test4() {
		// #if BASE && GENERATOR && SOLVER && STATES && UNDO
		SudokuFacade sf = new SudokuFacade();
		sf.GenerateSudoku();
		System.out.println("test4");
		// #endif
	}

}
