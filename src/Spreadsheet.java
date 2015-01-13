
public class Spreadsheet {
 
 // private fields
  private Cell[][] cells;
  private static int rows=11;
  private static int cols=8;
  private static int columnWidth=12;
  private static int asciiOffset=64;
  private String border;
  private String borderRow;
 
 // private methods
 private static int getCol(String location) {
  //TODO  
   return (int)location.charAt(0)-asciiOffset;
 }
 
 private static int getRow(String location) {
  //TODO
   return Integer.parseInt(location.substring(1));
 }
 
 private static String padOrTruncateDisplayString(Cell cell) {
     // truncate string to length - 1 and display >
     String s = cell.getDisplayString();
     if (s.length() > columnWidth) {
       s = s.substring(0, columnWidth - 1) + ">";
     }
     // if length is odd pad end to even length
     if (s.length() % 2 == 1) {
       s += " ";
     }
     // justify pad to center in cell
     while (s.length() < columnWidth) {
       s = " " + s + " ";
     }
     return s;
 }
 
 // constructor
 public Spreadsheet() {
  //TODO
   cells=new Cell[rows][cols];
   border="|";
   borderRow="------------+";
 }
 
 // mutators
 public void setCell(String location, Cell cell) {
  //TODO
   int col=getCol(location);
   int row=getRow(location);
   cells[row][col]=cell;
 }
 
 // accessors
 public Cell getCell(String location) {
  // TODO
   int col=getCol(location);
   int row=getRow(location);
   return cells[row][col];
 }
 
 public void print() {
  // TODO    
   setCell("A0",new CellString("A"));
   setCell("B0",new CellString("B"));
   setCell("C0",new CellString("C"));
   setCell("D0",new CellString("D"));
   setCell("E0",new CellString("E")); 
   setCell("F0",new CellString("F"));
   setCell("G0",new CellString("G"));
   for(int i=1;i<rows;i++)
   {
     cells[i][0]=new CellString(""+i);
   }
   for(int row=0;row<rows;row++)
   {
     System.out.println();
     for(int col=0;col<cols;col++)
     {
       if(cells[row][col]==null)
       {
         cells[row][col]=new CellString();
       }
       System.out.print(padOrTruncateDisplayString(cells[row][col])+border);
     }
     System.out.println();
     for(int i=0;i<cols;i++)
     {
       System.out.print(borderRow);
     }
   }
 }
}
