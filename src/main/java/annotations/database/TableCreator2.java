package annotations.database;

import java.util.ArrayList;
import java.util.List;

/**
 * @packgeName: annotations.database
 * @ClassName: TableCreator2
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/10-19:15
 * @version: 1.0
 * @since: JDK 1.8
 */
public class TableCreator2 {

    public static void main(String[] args) throws ClassNotFoundException {

        if(args.length < 1){
            System.out.println("arguments: annotate classes");
            System.exit(0);
        }

        for (String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable ");
                continue;
            }
            String tableName = dbTable.name();
            if(tableName.length() <1){
                tableName = cl.getName().toLowerCase();
            }

            List<String> columnDefs = new ArrayList<String>();



        }


    }
}
