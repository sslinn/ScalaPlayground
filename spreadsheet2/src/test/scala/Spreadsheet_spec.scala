import org.scalatest.{FreeSpecLike, FreeSpec, MustMatchers}
import org.scalatest.prop.TableDrivenPropertyChecks

class Spreadsheet_spec extends FreeSpec with TableDrivenPropertyChecks with MustMatchers {

    val validGridCells = Table(
        ("column", "row"),
        ("A", 1), ("A", 2), ("A", 3),("A", 4),("A", 5),("A", 6),("A", 7),("A", 8),("A", 9),("A", 10),
        ("B", 1), ("B", 2), ("B", 3),("B", 4),("B", 5),("B", 6),("B", 7),("B", 8),("B", 9),("B", 10),
        ("C", 1), ("C", 2), ("C", 3),("C", 4),("C", 5),("C", 6),("C", 7),("C", 8),("C", 9),("C", 10),
        ("D", 1), ("D", 2), ("D", 3),("D", 4),("D", 5),("D", 6),("D", 7),("D", 8),("D", 9),("D", 10),
        ("E", 1), ("E", 2), ("E", 3),("E", 4),("E", 5),("E", 6),("E", 7),("E", 8),("E", 9),("E", 10),
        ("F", 1), ("F", 2), ("F", 3),("F", 4),("F", 5),("F", 6),("F", 7),("F", 8),("F", 9),("F", 10),
        ("G", 1), ("G", 2), ("G", 3),("G", 4),("G", 5),("G", 6),("G", 7),("G", 8),("G", 9),("G", 10),
        ("H", 1), ("H", 2), ("H", 3),("H", 4),("H", 5),("H", 6),("H", 7),("H", 8),("H", 9),("H", 10)
        
    )

    val invalidGridCells = Table(
        ("column", "row"),
        ("A", -1), ("B", 0), ("C", 11), ("D", 100), ("I", 1), ("X", 5),
        ("a", 3), ("b", 5), ("h", 50)
    )


   "After setting a cell within valid grid range the same value can be retrieved from that cell as a string" in {
       val sp = new Spreadsheet
       forAll(validGridCells){ (column: String, row: Int) =>
           sp.setCellValue(column, row, 96.34 + row)
           sp.getCellValue(column, row) must equal((96.34 + row).toString)
       }
   }

   "Setting a cell outside valid range causes error" in {
       val sp = new Spreadsheet
       forAll(invalidGridCells){ (column: String, row: Int) =>
           intercept[GridCellOutOfRange](sp.setCellValue(column, row, 22.3))
       }
   }

   "Cells with an empty value return and empty string" in {
       val sp = new Spreadsheet
       forAll(validGridCells) { (column: String, row: Int) =>
          sp.getCellValue(column, row) must equal("")
       }
   }

    "After emptying a cell the return value is an empty string" in {
        val sp = new Spreadsheet
        forAll(validGridCells) { (column: String, row: Int) =>
            sp.setCellValue(column, row, 456)
            sp.emptyCell(column, row)
            sp.getCellValue(column, row) must equal("")
        }
    }

    "Emptying a cell outside the valid range causes and error" in {
        val sp = new Spreadsheet
        forAll(invalidGridCells){ (column: String, row: Int) =>
            intercept[GridCellOutOfRange](sp.emptyCell(column, row))
        }
    }

    "The spreadsheet can be printed to the console in a grid format with labels and correct values in each cell" in {
        fail()
    }

    "After setting a cell value multiple times only the last value is returned" in {
        fail()
    }

}