package com.milan.net;

import com.milan.entity.DBEntity;
import com.milan.utils.DateUtil;
import com.milan.utils.PropertiesUtil;
import com.milan.utils.RegexUtil;

import java.sql.*;
import java.util.*;
public class MySqlHelper {
    private static MySqlHelper GamemallHelper = null;
    private static MySqlHelper UcenterHelper = null;
    private static MySqlHelper TradedbHelper = null;
    private static MySqlHelper AlistatiHelper = null;
    private static MySqlHelper TmmTestHelper = null;
    public static MySqlHelper getTmmTestHelper() {
        if (TmmTestHelper == null) {
            DBEntity dbEntity = PropertiesUtil.getMyDB();
            TmmTestHelper = new MySqlHelper(dbEntity.getUrl(), dbEntity.getUsername(), dbEntity.getPassword());
        }
        return TmmTestHelper;
    }
    public static MySqlHelper getGamemallHelper() {
        if (GamemallHelper == null) {
            DBEntity dbEntity = PropertiesUtil.getGamemallDB();
            GamemallHelper = new MySqlHelper(dbEntity.getUrl(), dbEntity.getUsername(), dbEntity.getPassword());
        }
        return GamemallHelper;
    }
    public static MySqlHelper getUcenterHelper() {
        if (UcenterHelper == null) {
            DBEntity dbEntity = PropertiesUtil.getUcenterDB();
            UcenterHelper = new MySqlHelper(dbEntity.getUrl(), dbEntity.getUsername(), dbEntity.getPassword());
        }
        return UcenterHelper;
    }
    public static MySqlHelper getTradedbHelper() {
        if (TradedbHelper == null) {
            DBEntity dbEntity = PropertiesUtil.getTradedb1DB();
            TradedbHelper = new MySqlHelper(dbEntity.getUrl(), dbEntity.getUsername(), dbEntity.getPassword());
        }
        return TradedbHelper;
    }
    public static MySqlHelper getAlistatiHelper() {
        if (AlistatiHelper == null) {
            DBEntity dbEntity = PropertiesUtil.getAlistatiDB();
            AlistatiHelper = new MySqlHelper(dbEntity.getUrl(), dbEntity.getUsername(), dbEntity.getPassword());
        }
        return AlistatiHelper;
    }

    private String dburl;
    private String uName;
    private String pwd;
    private Connection conn = null;
    private Statement statement = null;
    public MySqlHelper(String _dbUrl, String _user, String _pwd) {
        dburl = _dbUrl;
        uName = _user;
        pwd = _pwd;
        createConn();
    }
    private void createConn() {
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(dburl, uName, pwd);
            statement = conn.createStatement();
            if (conn.isClosed())
                System.out.println(" Database is isClosed");
        } catch (Exception e) {
            System.out.println("数据库连接失败");
            System.out.println(e);
            System.exit(0);
        }
    }
    public ResultSet executeQuery(String sql) {
        ResultSet r = null;
        try {
            r = statement.executeQuery(sql);
        } catch (Exception e) {
            // e.printStackTrace();
        } finally {
            return r;
        }
    }
    //批量执行sql语句
    public List executeSqlBatch(String sqlList) {
        String[] strList = sqlList.split(";");
        List rl = new ArrayList();
        for (int i = 0; i < strList.length; i++) {
            String strSql = strList[i].toLowerCase();
            if (strSql.equals("")) {
                continue;
            } else if (strSql.indexOf("set") > -1
                    || strSql.indexOf("select") > -1 || strSql.indexOf("insert") > -1
                    || strSql.indexOf("delete") > -1 || strSql.indexOf("update") > -1) {
                if (strSql.toLowerCase().indexOf("select") > -1) {
                    Map m = new HashMap();
                    String tableName = RegexUtil.getMatcher("from +(\\w*)", strList[i]);
                    if (strSql.indexOf("from") == -1) {
                        tableName = RegexUtil.getMatcher("select +(.*)", strSql);
                    }
                    m.put(tableName, executeQueryList(strSql));
                    rl.add(m);
                } else {
                    executeUpdate(strList[i]);
                }
            }
        }
        return rl;
    }
    //返回第一行第一列转换成Int
    public int executeInt(String sql) {
        int i = 0;
        try {
            ResultSet r = executeQuery(sql);
            if (r != null && r.next()) {
                i = r.getInt(1); // Integer.parseInt(r.getObject(1).toString()) ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    //返回第一行第一列转换成String
    public String executeStr(String sql) {
        String str = "";
        try {
            ResultSet r = executeQuery(sql);
            if (r != null && r.next()) {
                str = r.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }

    //是否执行成功
    public boolean execute(String sql) {
        boolean r = false;
        try {
            r = statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    public void executeUpdate(String sql) {
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 返回第一行数据
    public Map executeMap(String sql) {
        Map row = null;
        List l = executeQueryList(sql);
        if (l != null && l.size() > 0) {
            row = (Map) l.get(0);
        }
        return row;
    }

    public List executeQueryList(String sql) {
        return resultSetToList(executeQuery(sql));
    }

    private static List<Map> resultSetToList(ResultSet rs) {
        List list = new ArrayList();
        if (rs == null) {
            return list;
        }

        ResultSetMetaData md = null; //得到结果集(rs)的结构信息，比如字段数、字段名等
        try {
            md = rs.getMetaData();
            int columnCount = md.getColumnCount(); //返回此 ResultSet 对象中的列数
            Map rowData = new HashMap();
            while (rs.next()) {
                rowData = new HashMap(columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                    if (md.getColumnName(i).indexOf("time") > -1 && rs.getObject(i) != null) {
                        rowData.put(md.getColumnName(i) + "__date", DateUtil.getDataByUtime(rs.getObject(i).toString()));
                    }
                }
                list.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}