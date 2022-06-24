package com.rcdu.medu.databaseFiles;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseManipulate {

    private static final String DATABASE_NAME = "mEDU.sqlite";
    private static final int DATABASE_VERSION = 1;
    private DataBaseHelper objDataBaseHelper;
    private static Context context;
    private static SQLiteDatabase objSqliteDB;


    public static final String LOGIN_CONSTANT_DELETE = "constants_flag";
    public static final String LOGIN_COURSE_TABLE = "login_course";
    public static final String LOGIN_SUBJECT_TABLE = "login_subject";
    public static final String LOGIN_SEMESTER_TABLE = "login_semester";
    public static final String LOGIN_SECTION_TABLE = "login_section";
    public static final String LOGIN_CLASS_TYPE_TABLE = "login_class_type";
    public static final String LOGIN_CLASS_STUDENTS_DETAILS_TABLE = "login_students_details";
    public static final String LOGIN_LEAVE_TYPE_TABLE = "login_leave_type";
    public static final String LOGIN_ASSESSMENT_TYPE = "login_assessment_type";
    public static final String LOGIN_PAPER_TYPE = "login_paper_type";
    public static final String LOGIN_PRIORITY_MASTER_TYPE = "login_priority_master_type";
    public static final String LOGIN_DEPARTMENT_MASTER_TYPE = "login_department_master_type";
    public static final String LOGIN_TIME_PERIOD_TYPE = "login_time_period_type";
    public static final String TAKE_STUDENT_ATTENDANCE = "take_student_attendance";
    public static final String EDIT_STUDENT_ATTENDANCE_DATA = "edit_student_attendance_data";
    public static final String lasttimesyncdateandtime = "lasttimesyncdateandtime";

    public static final String LOGIN_DEALER_TABLE = "Dealer";
    public static final String LOGIN_BEAT_TABLE = "beat_insert_table";
    public static final String LOGIN_LOCATION_TABLE = "location_data_insert_sale_table";
    public static final String LOGIN_RETAILER_TABLE = "retailer_data_insert";

    public static final String userColleague = "userColleague";
    public static final String userColleagueAutoId = "id";
    public static final String userColleagueId = "userColleagueId";
    public static final String userColleagueName = "userColleagueName";

    public static final String createUserColleague = "create table " + userColleague
            + "(" + userColleagueAutoId + " INTEGER primary key Autoincrement,"
            + userColleagueId + " TEXT,"
            + userColleagueName + " TEXT);";

    public static final String LOGIN_APP_MODULE = "login_app_module";
    public static final String LOGIN_SUB_APP_MODULE = "login_sub_app_module";
    public static final String LOGIN_OTHER_APP_MODULE = "login_other_app_module";

    public static final String WorkngStatus_TABLE = "WorkingStatus_table";

    public static final String workingstatusId = "WorkingStatusId";
    public static final String woringStatusd1 = "WorkingStatusId1";
    public static final String workingStatusName = "WorkingStatusName";

    public static final String createWorkingStatus = "create table WorkingStatus_table(WorkingStatusId Integer primary key Autoincrement,"
            + "WorkingStatusId1 TEXT,"
            + "WorkingStatusName TEXT,"
            + "delete_status Integer DEFAULT 0)";

    public static final String LOGIN_URL_LIST = "login_url_list";


    public static final String LOGIN_Classification_TABLE = "classification_data_insert";

    public static final String LOGIN_PRODUCT_CATAGORY_TABLE = "product_category_table";

    public static final String Product_TABLE = "Product_table";
    public static final String colProductId = "ProductId";
    public static final String colProductId1 = "ProductId1";
    public static final String colTotalProductName = "ProductName";
    public static final String colProductValue = "ProductValue";
    public static final String colProductUnit = "p_unit";
    public static final String colProductCategoryId = "ProductcategoryId";
    public static final String colProductMrp = "ProductMrp";
    public static final String colProductFocus = "focus";
    public static final String colProductScheme = "scheme";
    public static final String colProductSchemeQuantity = "scheme_qty";
    public static final String colProductClassification = "classificationid";
    public static final String colProductClassificationName = "classificationname";
    public static final String colProductcaseValue = "productCaseValue";
    public static final String colProductTax = "producttax";
    public static final String Focus_Target = "focus_target";
    public static final String dealer_rate = "dealer_rate";
    public static final String dealer_pcs_rate = "dealer_pcs_rate";
    public static final String product_pcs_mrp = "pcs_mrp";

    public static final String createProductTable = "create table Product_table(ProductId Integer primary key Autoincrement,"
            + "ProductId1 TEXT,"
            + "ProductName TEXT,"
            + "ProductValue TEXT,"
            + "p_unit TEXT,"
            + "ProductcategoryId TEXT ,"
            + "ProductMrp TEXT,"
            + "scheme TEXT,"
            + "focus TEXT,"
            + "focus_target TEXT,"
            + "scheme_qty TEXT,"
            + "classificationid TEXT,"
            + "classificationname TEXT,"
            + "productCaseValue TEXT,"
            + "producttax TEXT,"
            + dealer_rate + " TEXT,"
            + product_pcs_mrp + " TEXT,"
            + dealer_pcs_rate + " TEXT,"
            + "delete_status Integer DEFAULT 0)";

    public static final String LOGIN_PRODUCT_TABLE = "product_data_insert_sale_table";


    public static final String LOGIN_STATE = "login_state";

    public static final String userTown = "userTown";
    public static final String userTownAutoId = "id";
    public static final String userTownId = "userTownId";
    public static final String userTownName = "userTownName";
    public static final String userTownStateId = "userTownStateId";

    public static final String createUserTown = "create table " + userTown
            + "(" + userTownAutoId + " INTEGER primary key Autoincrement,"
            + userTownId + " TEXT,"
            + userTownStateId + " TEXT,"
            + userTownName + " TEXT);";


    public static final String TABLE_CLOSE_THE_DAY = "close_the_day";
    public static final String Comment_new_Table = "comment_new_table";
    public static final String TABLE_REPORT1 = "marketreport_one_table";
    public static final String TABLE_REPORT2 = "marketreport_two_table";
    public static final String GENERAL_TRADE_MEETINGS = "general_trade_meetings";

    // ModernTrade Meetings Data Table & Columns
    public static final String MODERN_TRADE_MEETINGS = "modern_trade_meetings";

    public static final String tm_id = "id";
    public static final String tm_start_time = "start_time";
    public static final String tm_duration = "duration";
    public static final String tm_dsm_name = "dsm_name";
    public static final String tm_so_name = "so_name";
    public static final String tm_asm_name = "asm_name";
    public static final String tm_rsm_name = "rsm_name";
    public static final String tm_sm_agm_name = "sm_agm_name";
    public static final String tm_sales_head = "sales_head";
    public static final String tm_segment_wise_target = "segment_wise_target";
    public static final String tm_first_product = "first_product";
    public static final String tm_second_product = "second_product";
    public static final String tm_third_product = "third_product";
    public static final String tm_is_a_class_outlet = "is_a_class_outlet";
    public static final String tm_is_sales_performance = "is_sales_performance";
    public static final String tm_is_primary_secondary_scheme = "is_primary_secondary_scheme";
    public static final String tm_is_stock_shortage = "is_stock_shortage";
    public static final String tm_is_retailer_replacement = "is_retailer_replacement";
    public static final String tm_so_one_travelling = "so_one_travelling";
    public static final String tm_so_two_travelling = "so_two_travelling";
    public static final String tm_latitude = "latitude";
    public static final String tm_longitude = "longitude";
    public static final String tm_geo_address = "geo_address";
    public static final String tm_mcc_mnc = "mcc_mnc";
    public static final String tm_unique_id = "unique_id";
    public static final String tm_user_id = "user_id";
    public static final String tm_user_role = "user_role";
    public static final String tm_cur_date = "cur_date";
    public static final String tm_cur_time = "cur_time";
    public static final String tm_image = "image";
    public static final String tm_isr_name = "isr_name";
    public static final String tm_so_target = "so_target";
    public static final String tm_isr_so = "isr_so";
    public static final String alltype = "All";


    // GeneralTrade Meetings table
    public static final String GENERAL_TRADE_MEETINGS_TABLE = "CREATE TABLE " + GENERAL_TRADE_MEETINGS + " ("
            + tm_id + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + tm_start_time + " TEXT ,"
            + tm_duration + " TEXT,"
            + tm_dsm_name + " TEXT,"
            + tm_so_name + " TEXT,"
            + tm_asm_name + " TEXT,"
            + tm_rsm_name + " TEXT, "
            + tm_sm_agm_name + " TEXT, "
            + tm_sales_head + " TEXT,"
            + tm_segment_wise_target + " TEXT, "
            + tm_first_product + " TEXT,"
            + tm_second_product + " TEXT,"
            + tm_third_product + " TEXT,"
            + tm_is_a_class_outlet + " TEXT,"
            + tm_is_sales_performance + " TEXT,"
            + tm_is_primary_secondary_scheme + " TEXT,"
            + tm_is_stock_shortage + " TEXT,"
            + tm_is_retailer_replacement + " TEXT,"
            + tm_so_one_travelling + " TEXT,"
            + tm_so_two_travelling + " TEXT,"
            + tm_latitude + " TEXT,"
            + tm_longitude + " TEXT,"
            + tm_geo_address + " TEXT,"
            + tm_mcc_mnc + " TEXT,"
            + tm_unique_id + " TEXT,"
            + tm_user_id + " TEXT,"
            + tm_user_role + " TEXT,"
            + tm_cur_date + " TEXT,"
            + tm_cur_time + " TEXT,"
            + tm_image + " TEXT,"
            + " image_status Integer default 0,"
            + " delete_status Integer default 0)";

    // ModernTrade Meetings table
    public static final String MODERN_TRADE_MEETINGS_TABLE = "CREATE TABLE " + MODERN_TRADE_MEETINGS + " ("
            + tm_id + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + tm_start_time + " TEXT ,"
            + tm_duration + " TEXT ,"
            + tm_isr_name + " TEXT,"
            + tm_so_name + " TEXT,"
            + tm_asm_name + " TEXT,"
            + tm_rsm_name + " TEXT, "
            + tm_sales_head + " TEXT,"
            + tm_so_target + " TEXT, "
            + tm_so_one_travelling + " TEXT,"
            + tm_so_two_travelling + " TEXT,"
            + tm_is_sales_performance + " TEXT,"
            + tm_is_primary_secondary_scheme + " TEXT,"
            + tm_is_stock_shortage + " TEXT,"
            + tm_latitude + " TEXT,"
            + tm_longitude + " TEXT,"
            + tm_geo_address + " TEXT,"
            + tm_mcc_mnc + " TEXT,"
            + tm_unique_id + " TEXT,"
            + tm_user_id + " TEXT,"
            + tm_user_role + " TEXT,"
            + tm_cur_date + " TEXT,"
            + tm_cur_time + " TEXT,"
            + tm_image + " TEXT,"
            + " image_status Integer default 0,"
            + " delete_status Integer default 0)";


    // /SQLITE
    // STATEMENTs////////////////////////////////////////////////////////
    // login
    private SQLiteStatement user_pass;
    private SQLiteStatement travelling_mode_statement;
    private SQLiteStatement track_time_insert;

    // /Attandence
    //  private SQLiteStatement atten_insert;
    // Damag Replace
    private SQLiteStatement damage_replace_insert;
    // Complaint
    private SQLiteStatement complaint_insert;
    // For Gift Image Insertion
    private SQLiteStatement callwise_img_insert;
    // for Customer Creation
    private SQLiteStatement customer_store_insert;
    // for Customer Image Insertion
    private SQLiteStatement cust_img_insert;
    // For Daily Expense
    // private SQLiteStatement daily_report_insert;
    // for img_insert_daily_expense
    private SQLiteStatement img_insert_daily_expense;
    // For Tracking
    private SQLiteStatement track_statement;
    static final String NOTIFICATION = "trackNotification";
    // ///////////////////////////////////////////////////////////////////////////

    // Login
    public static final String LOGIN_DAILY_REPORTING = "daily_reporting";
    public static final String LOGIN_USERDETAIL = "userNamePass_Store_from_url";
    public static final String LOGIN_check_status = "LOGIN_check_status";
    public static final String LOGIN_check_status_tabel = "create table LOGIN_check_status(status_id INTEGER primary key ,"
            + "attn_status TEXT," + "dsr_status TEXT);";
    public static final String status_id = "status_id";
    public static final String attn_status = "attn_status";
    public static final String dsr_status = "dsr_status";
    public static final String new_searching = "new_searching";


    public static final String LOGIN_USERNAME_INSERT = "UserName_Return";

    public static final String EDIT_INFORMATION = "editinformation";

    public static final String SHARE_INFORMATION_COUNT = "shareinformationcount";

    public static final String RETAILER_LOCATION_TABLE = "retailer_location_insert";
    public static final String TODO_SUBJECT = "TODO_SUBJECT";
    public static final String TODO_DESC = "TODO_DESC";

    public static final String LOGIN_PRODUCT_Stock = "product_stock";
    public static final String LOGIN_Gift = "gift";
    public static final String LOGIN_ = "gift";

    public static final String LOGIN_PERCENTSCHEME_TABLE = "percentscheme";


    public static final String NEW_TRACKING = "new_track";
    public static final String LOGIN_PAYMENT_MODE = "payment_mode";


    public static final String LOGIN_ISRUSER_TABLE = "isruserdata";
    public static final String LOGIN_JUNIORUSER_TABLE = "junioruserdata";
    public static final String LOGIN_JUNIORUSER_Checkin = "juniorusercheckin";
    public static final String LOGIN_JUNIORUSER_Checkout = "juniorusercheckout";


    public static final String COUNT_TABLE_NOTI = "count_table_noti";


    public static final String TotalFulFillment_TABLE = "TotalFulFillment_table";
    public static final String colTotalFulFillmentId = "TotalFulFillmentId";
    public static final String colTotalFulFillmentRetailerId = "TotalFulFillmentRetailerId";
    public static final String colTotalFulFillmentRetailerName = "TotalFulFillmentRetailerName";
    public static final String colTotalFulFillmentProductId = "TotalFulFillmentProductId";
    public static final String colTotalFulFillmentProductName = "TotalFulFillmentProductName";
    public static final String colTotalFulFillmentOrderedQty = "TotalFulFillmentOrderedQty";
    public static final String colTotalFulFillmentFulfilledQty = "TotalFulFillmentFulfilledQty";
    public static final String colTotalFulFillmentSaleValue = "TotalFulFillmentSaleValue";
    public static final String colTotalFulFillmentTotalAmount = "TotalFulFillmentTotalAmount";
    public static final String createTotalFulFillmentTable = "create table TotalFulFillment_table(TotalFulFillmentId Integer primary key Autoincrement,"
            + "TotalFulFillmentRetailerId TEXT,"
            + "TotalFulFillmentRetailerName TEXT,"
            + "TotalFulFillmentProductId TEXT,"
            + "TotalFulFillmentProductName INTEGER,"
            + "TotalFulFillmentOrderedQty INTEGER ,"
            + "TotalFulFillmentFulfilledQty TEXT,"
            + "TotalFulFillmentSaleValue TEXT,"
            + "TotalFulFillmentTotalAmount TEXT, "
            + "delete_status Integer DEFAULT 0)";


    // Comment Data Table & Columns
    public static final String comment_data = "comment_data";

    public static final String comm_id = "id";
    public static final String comm_ord_id = "comm_ord_id";
    public static final String comm_date = "date";
    public static final String comm_time = "time";
    public static final String comm_user_id = "user_id";
    public static final String comm_loc_id = "loc_id";
    public static final String comm_dealer_id = "dealer_id";
    public static final String comm_retailer_id = "retailer_id";
    public static final String comm_retailer_name = "retailer_name";
    public static final String comm_latitude = "latitude";
    public static final String comm_longitude = "longitude";
    public static final String comm_mcc_mnc_lac = "mcc_mnc_lac";
    public static final String comm_rmk = "comm";
    public static final String comm_address = "comm_address";
    public static final String comm_battery_status = "battery_status";
    public static final String comm_gps_status = "gps_status";

    public static final String comm_in_time_stamp = "in_time_stamp";
    public static final String comm_out_time_stamp = "out_time_stamp";
    public static final String comm_timestamp = "time_stamp";


    // Competitive Price Intelligence Data Table & Columns
    public static final String COMPETITIVE_PRICE_INTELLIGENCE = "competitive_price_intelligence";

    public static final String cpi_id = "id";
    public static final String cpi_brand = "brand";
    public static final String cpi_weigth = "weigth";
    public static final String cpi_mrp = "mrp";
    public static final String cpi_being_sold_to_consumer = "being_sold_to_consumer";
    public static final String cpi_before_trade_scheme = "before_trade_scheme";
    public static final String cpi_trade_scheme = "trade_scheme";
    public static final String cpi_after_trade_scheme = "after_trade_scheme";
    public static final String cpi_units_per_case_bag = "units_per_case_bag";
    public static final String cpi_net_cost_price_to_retailer = "net_cost_price_to_retailer";
    public static final String cpi_retailer_margin_per_unit = "retailer_margin_per_unit";
    public static final String cpi_consumer_scheme = "consumer_scheme";
    public static final String cpi_must_enclose_cash_memo_no = "must_enclose_cash_memo_no";
    public static final String cpi_must_enclose_cash_memo_date = "must_enclose_cash_memo_date";
    public static final String cpi_latitude = "latitude";
    public static final String cpi_longitude = "longitude";
    public static final String cpi_location = "location";
    public static final String cpi_mcc_mnc = "mcc_mnc";
    public static final String cpi_battery_status = "battery_status";
    public static final String cpi_gps_status = "gps_status";
    public static final String cpi_order_id = "order_id";
    public static final String cpi_user_id = "user_id";
    public static final String cpi_cur_date = "cur_date";
    public static final String cpi_cur_time = "cur_time";


    // Feedback/Suggestion Data Table & Columns
    public static final String FEEDBACK_SUGGESTION = "feedback_suggestion";

    public static final String fs_id = "id";
    public static final String fs_suggestion = "suggestion";
    public static final String fs_suggested_start_date = "suggested_start_date";
    public static final String fs_estimated_volume_growth = "estimated_volume_growth";
    public static final String fs_latitude = "latitude";
    public static final String fs_longitude = "longitude";
    public static final String fs_location = "location";
    public static final String fs_mcc_mnc = "mcc_mnc";
    public static final String fs_order_id = "order_id";
    public static final String fs_user_id = "user_id";
    public static final String fs_cur_date = "cur_date";
    public static final String fs_cur_time = "cur_time";
    public static final String fs_battery_status = "battery_status";
    public static final String fs_gps_status = "gps_status";


    // Competitive Price Intelligence Data Table & Columns
    public static final String PENDING_CLAIM = "pending_claim";

    public static final String pc_id = "id";
    public static final String pc_submission_date = "submission_date";
    public static final String pc_distributor_id = "distributor_id";
    public static final String pc_town_id = "town_id";
    public static final String pc_nature_of_claim = "nature_of_claim";
    public static final String pc_invoice_number = "invoice_number";
    public static final String pc_invoice_date = "invoice_date";
    public static final String pc_claim_paper = "claim_paper";
    public static final String pc_remark = "remark";
    public static final String pc_expected_resolution_date = "expected_resolution_date";
    public static final String pc_latitude = "latitude";
    public static final String pc_longitude = "longitude";
    public static final String pc_location = "location";
    public static final String pc_mcc_mnc = "mcc_mnc";
    public static final String pc_battery_status = "battery_status";
    public static final String pc_gps_status = "gps_status";
    public static final String pc_order_id = "order_id";
    public static final String pc_user_id = "user_id";
    public static final String pc_cur_date = "cur_date";
    public static final String pc_cur_time = "cur_time";


    // Complaint Report Table Name:-
    public static final String ComplaintReport = "complaint_report";

    //Travelling Expense BIll Table Name:-
    public static final String TravellingExpenseBill = "travelling_expense_bill";

    //Product Investigation Report:-
    public static final String ProductInvestigationReport = "product_investigation_report";

    // Retailer Table & Columns
    public static final String retailer_images = "retailer_images";

    public static final String retailer_auto_inc_id = "id";
    public static final String retailer_ord_id = "ord_id";
    public static final String retailer_date = "date";
    public static final String retailer_time = "time";
    public static final String retailer_user_id = "user_id";
    public static final String retailer_loc_id = "loc_id";
    public static final String retailer_dealer_id = "dealer_id";
    public static final String retailer_id = "retailer_id";
    public static final String retailer_name = "retailer_name";
    public static final String retailer_latitude = "latitude";
    public static final String retailer_longitude = "longitude";
    public static final String retailer_mcc_mnc_lac = "mcc_mnc_lac";
    public static final String retailer_rmk = "remark";
    public static final String retailer_address = "address";
    public static final String retailer_battery_status = "battery_status";
    public static final String retailer_gps_status = "gps_status";
    public static final String retailer_in_time_stamp = "in_time_stamp";
    public static final String retailer_out_time_stamp = "out_time_stamp";
    public static final String retailer_timestamp = "time_stamp";
    public static final String retailer_image = "image";
    public static final String retailer_image2 = "image2";
    public static final String retailer_image3 = "image3";

    //Retailer Information
    public static final String RetailerTableConditional = "retailerTableConditional";
    public static final String CurrentDate = "CurrentTime";
    public static final String CurrentTime = "CurrentDate";
    public static final String OrderID = "OrderID";
    public static final String Lat = "Latitude";
    public static final String Long = "Longitude";
    public static final String RetailerID = "RetailerID";
    public static final String Address = "Address";
    public static final String RetailerTableGPS_STATUS = "gps_status";
    public static final String RetailerTableBATTERY_STATUS = "battery_status";
    public static final String MCC_MNC = "MCC_MNC";
    public static final String RetailerTableNew = "create table retailerTableConditional(Id Integer primary key Autoincrement,"
            + "CurrentTime TEXT,"
            + "CurrentDate TEXT,"
            + "OrderID TEXT,"
            + "Latitude TEXT,"
            + "Longitude TEXT,"
            + "RetailerID TEXT,"
            + "Address TEXT,"
            + "gps_status TEXT,"
            + "battery_status TEXT,"
            + "MCC_MNC TEXT,"
            + "delete_status Integer DEFAULT 0)";

    //Sahil
    public static final String TravellingMode_TABLE = "TravellingModde_table";
    public static final String travellingModeId = "TravellingModeId";
    public static final String colTravellingModeId1 = "TravellingModeId1";
    public static final String colTravellingModeName = "TravellingModeName";

    public static final String createTravellingMode = "create table TravellingModde_table(TravellingModeId Integer primary key Autoincrement,"
            + "TravellingModeId1 TEXT,"
            + "TravellingModeName TEXT,"
            + "delete_status Integer DEFAULT 0)";


    public static final String SYNC_Complaint_Redressel = "SYNC_Complaint_Redressel";


    public static final String TotalFulFillment_TABLE1 = "TotalFulFillment_table1";
    public static final String colTotalFulFillmentId1 = "TotalFulFillmentId";
    public static final String colTotalFulFillmentRetailerId1 = "ProductName";
    public static final String colTotalFulFillmentRetailerId2 = "ProductId";
    public static final String createTotalFulFillmentTable1 = "create table TotalFulFillment_table1(TotalFulFillmentId Integer primary key Autoincrement,"
            + "ProductName TEXT,"
            + "ProductId TEXT,"
            + "delete_status Integer DEFAULT 0)";

    //Reporting Manager FullFill Details:-
    public static final String ReportingManagerTable = "reportingManagerTable";
    public static final String SeniorName = "seniorName";
    public static final String RoleName = "roleName";
    public static final String ReportingManagerDetailsTable = "create table reportingManagerTable(TotalFulFillmentId Integer primary key Autoincrement,"
            + "seniorName TEXT,"
            + "roleName TEXT,"
            + "delete_status Integer DEFAULT 0)";


    public static final String CallwiseReportingImgTable = "CallwiseReportingImgTable";
    public static final String CallwiseReportingImgId = "Id";
    public static final String CallwiseReportingImg = "image";
    public static final String CallwiseReportingImgTime = "temp_pro_current_time";
    public static final String CallwiseReportingImgDate = "temp_pro_current_date";
    public static final String CallwiseReportingImgOrderId = "temp_pro_order_id";
    public static final String CreateCallWiseReportingtable = "create table CallwiseReportingImgTable(Id Integer primary key Autoincrement,"
            + "image TEXT,"
            + "temp_pro_current_time TEXT,"
            + "temp_pro_current_date TEXT,"
            + "temp_pro_order_id TEXT,"
            + "image_status Integer DEFAULT 0)";


    //Daily Reporting Table
    public static final String DailyReporting_table = "DailyReportingTable";
    public static final String colDailyReportingId = "DailyReportingId";
    public static final String colDailyReportingDailyReportingAttendanceId = "DailyReportingDailyReportingId";
    public static final String colDailyReportingDailyReportingTime = "DailyReportingDailyReportingTime";
    public static final String colDailyReportingDailyReportingDate = "DailyReportingDailyReportingDate";
    public static final String colDailyReportingIMEI = "DailyReportingIMEI";
    public static final String colDailyReportingDailyReportingCheckInLat = "DailyReportingDailyReportingCheckInLat";
    public static final String colDailyReportingDailyReportingCheckInLong = "DailyReportingDailyReportingCheckInLong";
    public static final String colDailyReportingDailyReportingMccMncLacCellid = "DailyReportingDailyReportingMccMncLacCellid";
    public static final String colDailyReportingOrderid = "DailyReportingOrderid";
    public static final String colDailyReportingWorkingWithName = "DailyReportingWorkingWithName";
    public static final String colDailyDistributorId = "DailyReportingDistributorId";
    public static final String colDailyDistributorBatteryStatus = "DailyReportingDistributorBatteryStatus";
    public static final String colDailyDistributorGPSStatus = "DailyReportingDistributorGPSStatus";
    public static final String colDailyReportingDailyReportingLocation = "DailyReportingDailyReportingLocation";
    public static final String colDailyReportingDailyReportingStatus = "DailyReportingDailyReportingStatus";
    public static final String colDailyReportingDailyReportingWorkingWith = "DailyReportingDailyReportingWorkingWith";
    public static final String colDailyReportingRemark = "DailyReportingRemark";
    public static final String colDailyReportingBeatId = "DailyReportingBeatId";
    public static final String createDailyReportingTable = "create table DailyReportingTable(DailyReportingId Integer primary key Autoincrement,"
            + "DailyReportingDailyReportingId TEXT,"
            + "DailyReportingDailyReportingTime TEXT,"
            + "DailyReportingDailyReportingDate TEXT,"
            + "DailyReportingIMEI TEXT,"
            + "DailyReportingDailyReportingCheckInLat TEXT ,"
            + "DailyReportingDailyReportingCheckInLong TEXT,"
            + "DailyReportingDailyReportingMccMncLacCellid TEXT,"
            + "DailyReportingOrderid TEXT, "
            + "DailyReportingWorkingWithName TEXT, "
            + "DailyReportingDistributorId TEXT, "
            + "DailyReportingDistributorBatteryStatus TEXT, "
            + "DailyReportingDistributorGPSStatus TEXT, "
            + "DailyReportingDailyReportingLocation TEXT,"
            + "DailyReportingDailyReportingStatus TEXT ,"
            + "DailyReportingDailyReportingWorkingWith TEXT,"
            + "DailyReportingRemark TEXT,"
            + "DailyReportingBeatId TEXT,"
            + "delete_status Integer DEFAULT 0)";


    public static final String Merchandise_TABLE = "Merchandise_TABLE";
    public static final String DAILY_PROSPECTING_WORK = "DAILY_PROSPECTING_WORK";
    public static final String COMPETITION_NEW_PRODUCT_LAUNCH_REPORT = "COMPETITION_NEW_PRODUCT_LAUNCH_REPORT";

    public static final String Merchandise_REQUIREMTENT_TABLE = "Merchandise_REQUIREMTENT_TABLE";

    //Counter Sale Table
    //By Sahil Gaba
    public static final String CounterSale_TABLE = "CounterSale_table";
    public static final String colCounterSaleId = "CounterSaleId";
    public static final String colCounterSaleDate = "CounterSaleDate";
    public static final String colCounterSaleDistributorId = "CounterSaleDistributorId";
    public static final String colCounterSaleBeatId = "CounterSaleBeatId";
    public static final String colCounterSalenewOutlet = "CounterSaleNewOutlet";
    public static final String colCounterSaleValueFromNewOutlet = "CounterSaleValueFromNewOutlet";
    public static final String colCounterSaleDistributorTotalSale = "CounterSaleDistributorTotalSale";
    public static final String colCounterSaleDistributorTotalCall = "CounterSaleDistributorTotalCall";
    public static final String colCounterSaleDistributorProductiveCall = "CounterSaleDistributorProductiveCall";
    public static final String colCounterSaleDistributordsm = "CounterSaleDistributordsm";
    public static final String colCounterSaleCheckInTime = "CounterSaleCheckInTime";
    public static final String colCounterSaleCheckOutTime = "CounterSaleCheckOutTime";
    public static final String colCounterSaleDistributorRemarks = "CounterSaleDistributorRemarks";
    public static final String colCounterSaleDistributorOrderid = "CounterSaleDistributorOrderid";
    public static final String createCounterSale_TABLE = "create table CounterSale_table(CounterSaleId Integer primary key Autoincrement,"
            + "CounterSaleDate TEXT,"
            + "CounterSaleDistributorId TEXT,"
            + "CounterSaleBeatId TEXT,"
            + "CounterSaleDistributorTotalSale TEXT,"
            + "CounterSaleNewOutlet TEXT,"
            + "CounterSaleValueFromNewOutlet TEXT,"
            + "CounterSaleDistributorTotalCall TEXT,"
            + "CounterSaleDistributorProductiveCall TEXT,"
            + "CounterSaleDistributordsm TEXT,"
            + "CounterSaleCheckInTime TEXT,"
            + "CounterSaleCheckOutTime TEXT,"
            + "CounterSaleDistributorRemarks TEXT,"
            + "CounterSaleDistributorOrderid TEXT,"
            + "delete_status Integer DEFAULT 0)";

    public static final String AppDeliveryTable = "Appdelivery";
    public static final String colAppdeliveryId = "AppdeliveryId";
    public static final String colAppdeliveryDate = "AppdeliveryDate";
    public static final String createAppDelivery_TABLE = "create table Appdelivery(AppdeliveryId Integer primary key Autoincrement,"
            + "AppdeliveryDate TEXT,"
            + "delete_status Integer DEFAULT 0)";


    public static final String LOGIN_DAMAGEPRODUCT_TABLE = "damageproduct_data_insert_sale_table";

    public static final String LOGIN_DAMAGEPRODUCT_CATAGORY_TABLE = "damageproduct_category_table";


    // User Colleague List


    public static final String PAYMENT_RECEIVED_DETAILS = "payment_received_details";
    public static final String PAYMENT_RECEIVED_RETAILER = "payment_received_retailer";

    static final String LOGIN_DEALER_SALE_TABLE = "dealer_data_insert_sale_table";

    public static final String LOGIN_COMPLAINT_TABLE = "complaint_types";

    public static final String LOGIN_NON_PRODUCTIVE = "non_productive_type";


    public static final String LOGIN_RETURN_REASON_TYPE = "return_reason_type";


    public static final String LOGIN_FEEDBACK_TABLE = "feedback_from";

    public static final String LOGIN_ISR_TABLE = "ISR";

    public static final String LOGIN_OUTLETS = "outlets";
    public static final String LOGIN_MTP_DATA = "mtpdata";
    public static final String LOGIN_TASK_OF_THE_DAY = "task_of_the_day";

    public static final String LEAVE_TYPE = "leavetype";
    public static final String USER_IMAGE = "userimage";

    public static final String SCHEME_TYPE = "schemetype";

    public static final String LOGIN_OWNERSHIPTYPE = "ownership_type";

    public static final String LOGIN_TRAVELLINGMODE = "travelling_modes";

    public static final String LOGIN_ROLE = "role_table";
    public static final String LOGIN_ROLE1 = "role_table1";

    public static final String LOGIN_FIELDEXPERINCE = "field_experience";

    public static final String LOGIN_ATTENDANCE_STATUS = "attn_status_table";

    public static final String LOGIN_MARKETGIFT = "gifts";

    public static final String LOGIN_MARITIAL_STATUS = "marital_status_table";

    public static final String LOGIN_RETAILER_ACHEIVEMENT = "login_retailer_acheivement";


    public static final String LOGIN_RETAILER_TARGET_BEAT = "LOGIN_RETAILER_TARGET_BEAT";


    public static final String RETAILER_TARGET_BEAT2 = "RETAILER_TARGET_BEAT2";

    public static final String LOGIN_CONSTANT_TRACKING = "constants_tracking";

    public static final String LOGIN_TRACK_INTERNET = "track_internet_cancel";

    public static final String LOGIN_TRACKINGTIME_MASTER = "trcking_time_master";

    public static final String LOGIN_TRACKING_STANDERDTIME = "startend_time";

    public static final String LOGIN_COMPETITIOR = "competitor";

    public static final String LOGIN_WORKING_WITH_STATUS = "Working_With_Status";

    public static final String CHECK_FOR_UPDATE_DATA = "check_for_update_data";

    public static final String MEETING_TABLE = "meeting_table";
    public static final String LOGIN_TYPE_MEETING = "login_type_meeting";
    public static final String LOGIN_MEETING_WITH_TYPE = "login_meeting_with_type";

    // ////////////////////////////////////////////////////////

    /* All Sync Tables */

    // ////////////Attandace table/////////////////////

    public static final String ATTENDANCE_STORETABEL = "attendance_store_table";

    public static final String SYNC_CHECKOUT_TABLE = "check_out";
    // For ISR
    public static final String SYNC_ISR_Detail = "ISR_Detail";
    public static final String isr_order_id = "isr_order_id";
    public static final String isr_orderstatus = "isr_orderstatus";

    public static final String SYNC_DAMAGE_REPLACE_TABLE = "damage_replace_table";
    private String Time = "time";
    private String Date = "date";

    public static final String SYNC_Complaint_Table = "complaint_table";


    public static final String SYNC_MERGE_RETAILER = "MERGE_RETAILER";

    public static final String createSYNC_MERGE_RETAILER_ID = "create table MERGE_RETAILER(id INTEGER primary key Autoincrement ,"
            + "old_ret_id TEXT,"
            + "new_ret_id TEXT,"
            + "submit_date TEXT,"
            + "submit_time TEXT,"
            + "delete_status INTEGER DEFAULT 0);";

    public static final String SYNC_BALANCESTOCK_TABLE = "balancestock";
    public static final String id = "id";

    public static final String SYNC_balance_report_userTable = "balance_user_table";
    static final String balance_report_userTable_id = "balance_user_table_id";
    static final String balance_report_userid = "balance_user_id";
    public static final String balance_report_username = "balance_user_name";
    public static final String balance_report_dealerid = "balance_dealer_id";
    public static final String balance_report_dealername = "balance_dealer_name";
    public static final String balance_report_designation = "balance_user_designation";

    public static final String SYNC_balance_report_sku_userTable = "balance_sku_user_table";
    static final String balance_report_sku_userTable_id = "balance_sku_user_table_id";
    static final String balance_report_sku_userid = "balance_sku_user_id";
    public static final String balance_sku_dealer_id = "balance_sku_dealer_id";
    public static final String balance_manu_date = "balance_manu_date";
    public static final String balance_sku_order_id = "balance_sku_order_id";
    public static final String balance_sku_today_date = "balance_sku_today_date";


    public static final String FulFillmentReportTotalTable = "FulFillmentReportTotal";
    public static final String colFulFillmentReportTotalTable_id = "FulFillmentReportTotal_id";
    public static final String colFulFillmentReportTotalTable_date1 = "FulFillmentReportTotalTable_date";
    public static final String colFulFillmentReportTotalTable_sale = "FulFillmentReportTotalTable_Sale";
    public static final String colFulFillmentReportTotalTable_delete_status = "delete_status";
    /*public static final String createFulFillmentReportTotalTable = "create table FulFillmentReportTotal(FulFillmentReportTotal_id INTEGER primary key autoincrement,"
            + "FulFillmentReportTotalTable_date TEXT,"
			+ "FulFillmentReportTotalTable_Sale Text,"
			+ "delete_status Integer DEFAULT 0);";*/
    private static final String createFulFillmentReportTotalTable = "CREATE TABLE " + FulFillmentReportTotalTable + "(" + colFulFillmentReportTotalTable_id + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + colFulFillmentReportTotalTable_date1 + " TEXT, "
            + colFulFillmentReportTotalTable_sale + " TEXT, "
            + colFulFillmentReportTotalTable_delete_status + " Integer DEFAULT 0);";

    //Sahil Gaba+++++++++++++++++

    public static final String FullfillmentReportRetailerTable = "FullfillmentReportRetailerTable";
    public static final String colFullfillmentRetailerId = "FullfillmentReportRetailerId";
    public static final String colFullfillmentRetailerName = "FullfillmentRetailerName";
    public static final String createFullfillmentReportRetailerTable = "create table FullfillmentReportRetailerTable(FullfillmentReportRetailerId INTEGER primary key ,"
            + "FullfillmentRetailerName TEXT)";


    public static final String FlightModeOnOffTable = "FlightModeOnOffTable1";
    public static final String colFlightModeOnOffId = "FlightModeOnOffId";
    public static final String colFlightModeOnOffDate = "FlightModeOnOffDate";
    public static final String colFlightModeOnOffTime = "FlightModeOnOffTime";
    public static final String colFlightModeOnOffStatus = "FlightModeOnOffStatus";
    public static final String colFlightModeOnOffOrderId = "FlightModeOnOffOrderId";
    public static final String createFlightModeOnOffTable = "create table FlightModeOnOffTable1(FlightModeOnOffId INTEGER primary key ,"
            + "FlightModeOnOffDate TEXT,"
            + "FlightModeOnOffTime TEXT,"
            + "FlightModeOnOffStatus TEXT,"
            + "FlightModeOnOffOrderId TEXT,"
            + "delete_status Integer DEFAULT 0)";


    //Sahil Gaba
    public static final String FullfillmentReportProductTable = "FullfillmentReportProductTable";
    public static final String colFullfillmentReportproducrid = "FullfillmentReportproducrid";
    public static final String colFullfillmentReportproductname = "FullfillmentReportproductname";
    public static final String colFullfillmentReportproductquantity = "FullfillmentReportproductquantity";
    public static final String colFullfillmentReportproductsalevalue = "FullfillmentReportproductsalevalue";
    public static final String colFullfillmentReportproductffamount = "FullfillmentReportproductffamount";
    public static final String colFullfillmentReportproductRetailerId = "FullfillmentReportproductRetailerId";
    public static final String createFullfillmentReportProductTable = "create table FullfillmentReportProductTable(FullfillmentReportproducrid INTEGER  ,"
            + "FullfillmentReportproductname TEXT,"
            + "FullfillmentReportproductquantity TEXT,"
            + "FullfillmentReportproductsalevalue TEXT,"
            + "FullfillmentReportproductRetailerId TEXT,"
            + "FullfillmentReportproductffamount TEXT);";


    // Outlet Category
    public static final String OutletCategoryTable = "outlet_category";
    public static final String OutletCategoryId = "id";
    public static final String OutletCategoryCode = "code";
    public static final String OutletCategoryName = "name";

    public static final String createOutletCategoryTable = "create table " + OutletCategoryTable + "(" + OutletCategoryId + " INTEGER primary key Autoincrement, "
            + OutletCategoryCode + " TEXT, "
            + OutletCategoryName + " TEXT);";


    //Sahil Gaba
    public static final String OutletTypeTable = "OutletTypeTable";
    public static final String OutletTypeid = "OutletTypeid";
    public static final String colOutletTypeid1 = "OutletTypeid1";
    public static final String colOutletTypeName = "OutletTypeName";

    public static final String createOutletTypeTable = "create table OutletTypeTable(OutletTypeid INTEGER primary key Autoincrement ,"
            + "OutletTypeid1 TEXT,"
            + "OutletTypeName TEXT,"
            + "delete_status TEXT);";

    //Delete Status Table:-
    public static final String DeleteStatusTable = "retailerDeleteStatusTabl";
    public static final String retailerDeleteId = "c_code";

    public static final String createdeleteStatusTable = "create table retailerDeleteStatusTable(id INTEGER primary key Autoincrement ,"
            + "c_code TEXT,"
            + "delete_status TEXT);";


    public static final String balance_report_sku_productname = "balance_sku_user_productname";
    public static final String balance_report_sku_quantity = "balance_sku_user_quantity";
    public static final String balance_report_sku_scheme = "balance_sku_user_scheme";


    public static final String SYNC_isrtempdatastore = "isrtempdatastore";

    public static final String isr_pro_id = "id";
    public static final String isr_pro_remarks = "remarks";
    public static final String isr_pro_image = "image";
    public static final String isr_pro_qty = "isr_pro_qty";
    public static final String isr_pro_mrp = "isr_pro_mrp";
    public static final String isr_pro_baseprice = "isr_pro_baseprice";
    public static final String isr_pro_schemeqty = "isr_pro_schemeqty";
    public static final String isr_pro_scheme = "isr_pro_scheme";
    public static final String isr_pro_total_value = "isr_pro_total_value";
    public static final String isr_pro_rate = "isr_pro_rate";
    public static final String isr_pro_group_id = "isr_pro_group_id";
    public static final String isr_pro_child_id = "isr_pro_child_id";
    public static final String isr_pro_child_name = "isr_pro_child_name";
    public static final String isr_pro_order_id = "isr_pro_order_id";
    public static final String isr_pro_dealerid = "isr_pro_dealerid";
    public static final String isr_pro_beatid = "isr_pro_beatid";
    public static final String isr_pro_retailerid = "isr_pro_retailerid";
    public static final String isr_pro_retailer_name = "isr_pro_retailer_name";
    public static final String isr_pro_category_name = "isr_pro_category_name";
    public static final String isr_pro_category_id = "isr_pro_category_id";
    public static final String isr_pro_discount = "isr_pro_discount";
    public static final String isr_pro_finalamount = "isr_pro_finalamount";
    public static final String isr_pro_orderstatus = "isr_pro_orderstatus";
    public static final String isr_pro_latitude = "isr_pro_latitude";
    public static final String isr_pro_longitude = "isr_pro_longitude";
    public static final String isr_pro_uid = "isr_pro_uid";
    public static final String isr_pro_focus = "isr_pro_focus";
    public static final String isr_pro_mcc_mnc_lac = "isr_pro_mcc_mnc_lac";
    public static final String isr_pro_current_time = "isr_pro_current_time";
    public static final String isr_pro_current_date2 = "isr_pro_current_date2";
    public static final String isr_pro_current_date = "isr_pro_current_date";
    public static final String isr_pro_imagename = "isr_pro_imagename";
    public static final String isr_pro_booked_order_type = "isr_pro_booked_order_type";
    public static final String isr_pro_stock_value = "isr_pro_stock_value";
    public static final String isr_pro_classification_value = "isr_pro_classification_value";
    public static final String isr_pro_category_value = "isr_pro_category_value";
    public static final String isr_pro_grpId_childId = "isr_pro_grpId_childId";
    public static final String isr_pro_images_status = "image_status";

    // CallWiseReproting Table
    public static final String SYNC_tempdatastore = "tempdatastore";

    public static final String temp_pro_id = "id";
    public static final String temp_pro_remarks = "remarks";
    public static final String temp_pro_non_productive_id = "temp_pro_non_productive_id";
    public static final String temp_pro_image = "image";
    public static final String temp_pro_qty = "temp_pro_qty";
    public static final String temp_pro_mrp = "temp_pro_mrp";
    public static final String temp_pro_baseprice = "temp_pro_baseprice";
    public static final String temp_pro_schemeqty = "temp_proscheme_qty";
    public static final String temp_pro_scheme = "temp_pro_scheme";
    public static final String temp_pro_total_value = "temp_pro_total_value";
    public static final String Focus = "focus";
    public static final String temp_pro_rate = "temp_pro_rate";
    public static final String temp_pro_group_id = "temp_pro_group_id";
    public static final String temp_pro_child_id = "temp_pro_child_id";
    public static final String temp_pro_child_name = "temp_pro_child_name";
    public static final String temp_pro_order_id = "temp_pro_order_id";
    public static final String temp_pro_dealerid = "temp_pro_dealerid";
    public static final String temp_pro_beatid = "temp_pro_beatid";
    public static final String temp_pro_retailerid = "temp_pro_retailerid";
    public static final String temp_pro_retailer_name = "retailer_name";
    public static final String temp_pro_category_name = "temp_pro_category_name";
    public static final String temp_pro_category_id = "temp_pro_category_id";
    public static final String temp_pro_discount = "temp_pro_discount";
    public static final String temp_pro_finalamount = "temp_pro_finalamount";
    public static final String temp_pro_orderstatus = "temp_pro_orderstatus";
    public static final String temp_pro_latitude = "temp_pro_latitude";
    public static final String temp_pro_longitude = "temp_pro_longitude";
    public static final String temp_pro_battery_status = "temp_pro_battery_status";
    public static final String temp_pro_gps_status = "temp_pro_gps_status";
    public static final String temp_pro_uid = "temp_pro_uid";


    public static final String temp_pro_distance_status = "distance_status";
    public static final String temp_pro_distance = "temp_pro_distance";


    public static final String temp_pro_focus = "temp_pro_focus";
    public static final String temp_pro_mcc_mnc_lac = "temp_pro_mcc_mnc_lac";
    public static final String temp_pro_current_time = "temp_pro_current_time";
    public static final String temp_pro_current_date2 = "temp_pro_current_date2";
    public static final String temp_pro_current_date = "temp_pro_current_date";
    public static final String temp_pro_imagename = "temp_pro_imagename";
    public static final String temp_pro_booked_order_type = "booked_order_type";
    public static final String temp_pro_stock_value = "temp_pro_stock_value";
    public static final String temp_pro_classification_value = "temp_pro_classification_value";
    public static final String temp_pro_category_value = "temp_pro_category_value";
    public static final String temp_pro_grpId_childId = "temp_pro_grpId_childId";
    public static final String temp_pro_images_status = "image_status";

    public static final String temp_pro_geo_address = "temp_pro_geo_address";
    public static final String temp_pro_user_id = "temp_pro_user_id";

    // Gift Table
    public static final String SYNC_GIFT_TABLE = "gift_table";
    // For CallWiseReporting Image
    static final String SYNC_CALLWISE_IMAGE = "callWise_img";
    // for Customer Creation
    public static final String SYNC_CREATE_RETAILER_TABLE = "customer_store_table";
    public static final String SYNC_RETAILER_IMAGE_TABLE = "cust_img";
    static final String SYNC_RETAILER_BRAND = "retailer_brand";
    public static final String SYNC_DAILYEXPENCE_IMAGE = "image_daily_expense";
    public static final String RETAILER_SCHEME_ENROLL = "RETAILER_SCHEME_ENROLL";


    // CallWiseReproting Table
    public static final String SYNC_RetailerStock = "retailerbalancestock1";

    public static final String reta_pro_id = "id";
    public static final String reta_pro_remarks = "remarks";
    public static final String reta_pro_image = "image";
    public static final String reta_pro_qty = "reta_pro_qty";
    public static final String reta_pro_schemeqty = "reta_proscheme_qty";
    public static final String reta_pro_scheme = "reta_pro_scheme";
    public static final String reta_pro_total_value = "reta_pro_total_value";
    public static final String reta_pro_rate = "reta_pro_rate";
    public static final String reta_pro_group_id = "reta_pro_group_id";
    public static final String reta_pro_child_id = "reta_pro_child_id";
    public static final String reta_pro_child_name = "reta_pro_child_name";
    public static final String reta_pro_stock_month = "reta_pro_stock_month";
    public static final String reta_pro_order_id = "reta_pro_order_id";
    public static final String reta_pro_dealerid = "reta_pro_dealerid";
    public static final String reta_pro_beatid = "reta_pro_beatid";
    public static final String reta_pro_battery_status = "reta_pro_battery_status";
    public static final String reta_pro_gps_status = "reta_pro_gps_status";
    public static final String reta_pro_retailerid = "reta_pro_retailerid";
    public static final String reta_pro_retailer_name = "retailer_name";
    public static final String reta_pro_orderstatus = "reta_pro_orderstatus";
    public static final String reta_pro_latitude = "reta_pro_latitude";
    public static final String reta_pro_longitude = "reta_pro_longitude";
    public static final String reta_pro_uid = "reta_pro_uid";
    public static final String reta_pro_mcc_mnc_lac = "reta_pro_mcc_mnc_lac";
    public static final String reta_pro_current_time = "reta_pro_current_time";
    public static final String reta_pro_current_date2 = "reta_pro_current_date2";
    public static final String reta_pro_current_date = "reta_pro_current_date";
    public static final String reta_pro_imagename = "reta_pro_imagename";
    public static final String reta_pro_booked_order_type = "booked_order_type";
    public static final String reta_pro_stock_value = "reta_pro_stock_value";
    public static final String reta_pro_classification_value = "reta_pro_classification_value";
    public static final String reta_pro_category_value = "reta_pro_category_value";
    public static final String reta_pro_grpId_childId = "reta_pro_grpId_childId";
    public static final String reta_pro_images_status = "image_status";

    /* For DamgeReplace Retailername */

    public static final String DamageReport_retailer = "damagereplaceretailer_datetable";
    public static final String damagereplaceretailer_id = "retailer_id";
    public static final String damagereplaceretailer_name = "retailer_name";

    /* For DamgeReport */
    public static final String DamageReport_damage = "damageproduct_datetable";
    public static final String DamageReport_pid = "damage_pid";
    public static final String DamageReport_name = "damage_name";
    public static final String DamageReport_qty = "damage_qty";
    public static final String DamageReport_mrp = "damage_mrp";
    public static final String DamageReport_value = "damage_value";
    // public static final String DamageReport_totalvalue="damage_totalvalue";
    public static final String DamageReport_retailerid = "damage_retailerid";

    /* For Replace Report */
    public static final String ReplaceReport_replace = "replaceproduct_datetable";
    public static final String ReplaceReport_pid = "replace_pid";
    public static final String ReplaceReport_name = "replace_name";
    public static final String ReplaceReport_qty = "replace_qty";
    public static final String ReplaceReport_mrp = "replace_mrp";
    public static final String ReplaceReport_value = "replace_value";
    // public static final String ReplaceReport_totalvalue="replace_totalvalue";
    public static final String ReplaceReport_retailerid = "replace_retailerid";


    public static final String dealer_ss_table = "dealer_ss";
    public static final String dealer_ss_table_id = "id";
    public static final String ss_id = "ss_id";
    public static final String ss_name = "ss_name";

    // *************Start Root plan Table ******************\\
    public static final String Root_plan_s = "Root_Plan";
    public static final String date_s = "date";
    public static final String status = "status";
    public static final String distributor_s = "distributor";
    public static final String beat_s = "beat";
    public static final String Total_call_s = "Total_call";
    public static final String del_status = "delete_status";
    public static final String Total_cell_value_s = "Total_cell_value";
    public static final String Root_plan_id = "Root_plan_id";
    public static final String dCode = "DCode";
    public static final String lCode = "LCode";
    public static final String town_id = "town_id";
    public static final String c_date = "c_date";
    public static final String mode = "mode";
    public static final String fromlocation = "fromlocation";
    public static final String tolocation = "tolocation";
    public static final String totaldtnce = "totaldtnce";
    public static final String sscode = "sscode";
    public static final String mtpday = "mtpday";
    public static final String mtpbattery_status = "mtpbattery_status";
    public static final String mtpgps_status = "mtpgps_status";
    public static final String any_other_task = "any_other_task";
    public static final String new_outlet_opening = "new_outlet_opening";
    public static final String primary_order = "primary_order";
    public static final String collection11 = "collection11";
    public static final String rd = "rd";
    public static final String pc = "pc";
    public static final String mtp_status = "mtp_status";


    public static final String Root_Plan_table = "create table Root_Plan(Root_plan_id Integer primary key ,"
            + "date TEXT,"
            + "distributor TEXT,"
            + "beat TEXT,"
            + "Total_call INTEGER,"
            + "Total_cell_value INTEGER ,"
            + "status TEXT,"
            + "DCode TEXT,"
            + "LCode TEXT, "
            + "c_date TEXT, "
            + "mode TEXT, "
            + "fromlocation TEXT, "
            + "tolocation TEXT, "
            + "totaldtnce TEXT, "
            + "sscode TEXT, "
            + "mtpday TEXT, "
            + "any_other_task TEXT, "
            + "new_outlet_opening TEXT, "
            + "primary_order TEXT, "
            + "collection11 TEXT, "
            + "rd TEXT, "
            + "pc TEXT, "
            + "dealerssid TEXT, "
            + "dcodeid TEXT, "
            + "statusid TEXT, "
            + "beatid TEXT, "
            + "mtpbattery_status TEXT, "
            + "mtpgps_status TEXT, "
            + "travelimgmode TEXT, "
            + town_id + " Text, "
            + mtp_status + " Text,"
            + "user_id Text,"
            + "category Text DEFAULT 'No', "
            + "delete_status Integer DEFAULT 0)";

    static final String viewRootPlan = "viewRootPlan";

    /* For Monthly PLANNED RECORD */

    public static final String planned_report_table = "planned_datetable";
    static final String planned_report_table_id = "_id";
    static final String planned_report_dealer_id = "dealer_id";
    public static final String planned_report_table_date = "date";
    static final String planned_report_table_dealer = "dealer";
    static final String planned_report_table_location = "location";
    static final String planned_report_table_totalcalls = "totalcalls";
    static final String planned_report_table_totalsale = "totalsale";
    static final String planned_report_table_totaldistance = "totaldistance";
    static final String planned_report_table_tfrom = "tfrom";
    static final String planned_report_table_tto = "tto";
    static final String planned_report_table_tmode = "tmode";
    static final String planned_report_table_status = "status";

    /* For Monthly ACTUAL RECORD */

    public static final String actual_report_table = "actual_datetable";
    static final String actual_report_table_id = "_id";
    static final String actual_report_dealer_id = "dealer_id";
    public static final String actual_report_table_date = "date";
    static final String actual_report_table_dealer = "dealer";
    static final String actual_report_table_location = "location";
    static final String actual_report_table_totalcalls = "totalcalls";
    static final String actual_report_table_totalsale = "totalsale";
    static final String actual_report_table_totaldistance = "totaldistance";
    static final String actual_report_table_tfrom = "tfrom";
    static final String actual_report_table_tto = "tto";
    static final String actual_report_table_tmode = "tmode";
    static final String actual_report_table_status = "status";
    public static final String SYNC_NOTIFICATION = "notification";

    // *************Payment Collection Data Record************\\
    public static final String Payment_Collection_Data_t = "Payment_Collection_Data";


    public static final String dealercode2 = "dealercode2";
    public static final String locationcode2 = "locationcode2";
    public static final String retailercode2 = "retailercode2";
    public static final String paymode2 = "paymode2";
    public static final String amount2 = "amount2";
    public static final String bbranch2 = "bbranch2";
    public static final String chequeno2 = "chequeno2";
    public static final String chequedate2 = "chequedate2";
    public static final String transactionno2 = "transactionno2";
    public static final String transactiondate2 = "transactiondate2";
    public static final String date2 = "date2";
    public static final String time2 = "time2";
    public static final String payment_battery_status = "battery_status";
    public static final String payment_gps_status = "gps_status";
    public static final String data_id = "data_id";
    public static final String imei2 = "imei2";

    public static final String Payment_Collection_Data_table = "create table Payment_Collection_Data(data_id INTEGER primary key autoincrement,"
            + "dealercode2 TEXT,"
            + "locationcode2 TEXT,"
            + "retailercode2 TEXT,"
            + "paymode2 TEXT,"
            + "amount2 TEXT,"
            + "bbranch2 TEXT,"
            + "chequeno2 TEXT,"
            + "chequedate2 TEXT,"
            + "transactionno2 TEXT,"
            + "transactiondate2 TEXT,"
            + "date2 Text,"
            + "time2 Text,"
            + "battery_status Text,"
            + "gps_status Text,"
            + "imei2 Text,"
            + "delete_status Integer DEFAULT 0);";

    // For Report Under
    //ESS Question Survey Table:-
    public static final String EssQuestionSurvey = "EssQuestionSurveyTable";
    public static final String QuestionId = "questionId";
    public static final String QuestionType = "questionType";
    public static final String QuestionName = "questionName";

    public static final String EssQuestionSurveyTable = "create table EssQuestionSurveyTable(id INTEGER primary key Autoincrement ,"
            + "questionId TEXT UNIQUE,"
            + "questionType TEXT,"
            + "questionName TEXT , "
            + "delete_status TEXT);";

    //ESS Question Type Table:-
    public static final String EssQuestionType = "EssQuestionTypeTable";
    public static final String QuestionTypeId = "questionTypeId";
    public static final String QuestionTypeName = "questionTypeName";

    public static final String EssQuestionTypeTable = "create table EssQuestionTypeTable(id INTEGER primary key Autoincrement ,"
            + "questionTypeId TEXT UNIQUE,"
            + "questionTypeName TEXT,"
            + "delete_status TEXT);";


    //ESS Question Options Table:-
    public static final String EssQuestionOption = "EssQuestionOptionTable";
    public static final String QuestionOptionID = "questionOptionId";
    public static final String QuestionOptionShortName = "questionOptionShortName";
    public static final String QuestionOptionDescription = "questionOptionDescription";

    public static final String EssQuestionOptionTable = "create table EssQuestionOptionTable(id INTEGER primary key Autoincrement ,"
            + "questionOptionId TEXT UNIQUE,"
            + "questionOptionShortName TEXT,"
            + "questionOptionDescription TEXT,"
            + "delete_status TEXT);";

    //ESS Question getting Table:-
    public static final String EssQuestionGetting = "EssQuestionGettingTable";
    public static final String Question_Id = "questionId";
    public static final String Option_Id = "optionId";
    public static final String Question_Type_Id = "questionTypeId";
    public static final String Current_Date1 = "current_Date";

    public static final String EssQuestionGettingTable = "create table EssQuestionGettingTable(id INTEGER primary key Autoincrement ,"
            + "questionId TEXT ,"
            + "current_Date TEXT ,"
            + "optionId TEXT,"
            + "questionTypeId TEXT,"
            + "delete_status TEXT);";

    //Suggestion Getting Data Table:-
    public static final String SuggestionGettingTable = "SuggestionGettingTable";
    public static final String Suggestion_Data = "suggestionData";
    public static final String Current_Date_Suggestion = "current_Date";


    public static final String SuggestionGettingDataTable = "create table SuggestionGettingTable(id INTEGER primary key Autoincrement ,"
            + Current_Date_Suggestion + " TEXT,"
            + Suggestion_Data + " TEXT,"
            + "delete_status Integer DEFAULT 0);";

    //Employee Data Getting Table:-
    public static final String EmployeeDataGettingTable = "EmployeeDataGettingTable";
    public static final String Employee_Name = "employeeName";
    public static final String Employee_Designation = "employeeDesignation";
    public static final String Employee_Department = "employeeDepartment";
    public static final String Employee_Cadre = "employeeCadre";
    public static final String Employee_Band = "employeeBand";
    public static final String Employee_Date_Of_Joining = "employeeDateOfJoining";
    public static final String Employee_Date = "employeeDate";

    public static final String EmployeeDataGetting = "create table EmployeeDataGettingTable(id INTEGER primary key Autoincrement ,"
            + Employee_Name + " TEXT,"
            + Employee_Designation + " TEXT,"
            + Employee_Department + " TEXT,"
            + Employee_Cadre + " TEXT,"
            + Employee_Band + " TEXT,"
            + Employee_Date_Of_Joining + " TEXT,"
            + Employee_Date + " TEXT,"
            + "delete_status Integer DEFAULT 0);";


    public static final String retailerReShuffle = "retailerReShuffle";
    public static final String createRetailerReshuffle = "create table retailerReShuffle(id INTEGER primary key Autoincrement ,"
            + "ret_id TEXT,"
            + "order_id TEXT,"
            + "dealer_id TEXT,"
            + "ret_name TEXT,"
            + "old_sequence TEXT,"
            + "new_sequence TEXT,"
            + "date TEXT,"
            + "time TEXT,"
            + "delete_status Integer DEFAULT 0);";

    //ESS Hod Data Table:-
    public static final String EssAllData = "EssAllDataTable";

    public static final String HOD_Name = "HODName";
    public static final String HOD_Designation = "HODDesignation";
    public static final String HOD_Department = "HODDepartment";
    public static final String HOD_Cadre = "HODCadre";
    public static final String HOD_Band = "HODBand";
    public static final String HOD_Date_Of_Joining = "HODDateOfJoining";
    public static final String HOD_Date = "HODDate";
    public static final String Current_Date = "current_Date";


    public static final String EssAllDataTable = "create table EssAllDataTable(id INTEGER primary key Autoincrement ,"
            + Current_Date + " TEXT,"
            + Suggestion_Data + " TEXT,"
            + HOD_Name + " TEXT,"
            + HOD_Designation + " TEXT,"
            + HOD_Department + " TEXT,"
            + HOD_Cadre + " TEXT,"
            + HOD_Band + " TEXT,"
            + HOD_Date_Of_Joining + " TEXT,"
            + HOD_Date + " TEXT,"
            + "delete_status Integer DEFAULT 0);";

    public static final String Payment_Collection_Data_Distributor_t = "Payment_Collection_Data_Distributor";


    public static final String dealercode3 = "dealercode3";
    public static final String locationcode3 = "locationcode3";
    public static final String retailercode3 = "retailercode3";
    public static final String paymode3 = "paymode3";
    public static final String amount3 = "amount3";
    public static final String bbranch3 = "bbranch3";
    public static final String chequeno3 = "chequeno3";
    public static final String chequedate3 = "chequedate3";
    public static final String transactionno3 = "transactionno3";
    public static final String transactiondate3 = "transactiondate3";
    public static final String date3 = "date3";
    public static final String time3 = "time3";
    public static final String data_id3 = "data_id3";
    public static final String imei3 = "imei3";

    public static final String Payment_Collection_Data_Distributor_table = "create table Payment_Collection_Data_Distributor(data_id3 INTEGER primary key autoincrement,"
            + "dealercode3 TEXT,"
            + "locationcode3 TEXT,"
            + "retailercode3 TEXT,"
            + "paymode3 TEXT,"
            + "amount3 TEXT,"
            + "bbranch3 TEXT,"
            + "chequeno3 TEXT,"
            + "chequedate3 TEXT,"
            + "transactionno3 TEXT,"
            + "transactiondate3 TEXT,"
            + "date3 Text,"
            + "time3 Text,"
            + "imei3 Text,"
            + "delete_status Integer DEFAULT 0);";
    public static final String report_userTable = "user_table";
    static final String report_userTable_id = "user_table_id";
    static final String report_userid = "user_id";
    public static final String report_date = "user_date";
    public static final String report_username = "user_name";
    public static final String report_totalcalls = "user_totalcalls";
    public static final String report_totalsalevalue = "user_totalsalevalue";
    public static final String report_totalprodcalls = "user_totalprodcalls";
    public static final String report_user_beat_name = "user_beat_name";
    public static final String phone_status = "phone_status";

    //Target Report Showing Table:-
    public static final String Target_Report_Show = "Target_Report_Show";

    public static final String Target_Product_Name = "Target_Product_Name";
    public static final String Target_Date_Show = "Target_Date_Show";
    public static final String Total_Target_Show = "Total_Target_Show";
    public static final String Target_Achieved_Show = "Target_Achieved_Show";
    public static final String Target_Total_Sale_Value = "Target_Total_Sale_Value";

    public static final String Target_Report_Show_Table = "create table Target_Report_Show(id INTEGER primary key Autoincrement ,"
            + Target_Product_Name + " TEXT,"
            + Target_Date_Show + " TEXT,"
            + Total_Target_Show + " TEXT,"
            + Target_Achieved_Show + " TEXT,"
            + Target_Total_Sale_Value + " TEXT,"
            + "delete_status Integer DEFAULT 0);";


    public static final String report_sku_userTable = "sku_user_table";
    static final String report_sku_userid = "sku_user_id";
    public static final String report_sku_productname = "sku_user_productname";
    public static final String report_sku_quantity = "sku_user_quantity";
    public static final String report_sku_rate = "sku_user_rate";
    public static final String report_sku_totalsalerate = "sku_user_totalsalerate";
    public static final String RETAILER_SCHEME_DISCOVERY_OUTLET = "RETAILER_SCHEME_DISCOVERY_OUTLET";
    // Retailer Report
    public static final String REPORT_RETAILER = "category_retailer_wise";

    // Secondory sale New or Daily Sales Report

    public static final String Daily_Sales_Report_t = "Daily_Sales_Report";
    public static final String distributor = "distributor";
    public static final String location = "location";
    public static final String daily_totel_call = "daily_totel_call";
    public static final String daily_total_prod = "daily_total_prod";
    /*
     * public static final String gls="gls"; public static final String tl="tl";
     * public static final String cfl="cfl"; public static final String
     * clm="clm";
     */
    public static final String Mtp_junior_table = "mtpjuniordata";


    public static final String colMtpJuniorId = "_id";
    public static final String colMtpJuniorDate = "date";
    public static final String colMtpJuniorCurrentDate = "current_date";
    public static final String colMtpJuniordealerid = "dealer";
    public static final String colMtpJuniormonth = "month";
    public static final String colMtpJuniortotalcalls = "totalcall";
    public static final String colMtpJuniortotalsales = "totalsale";
    public static final String colMtpJuniorsuperstockistname = "superstockist";
    public static final String colMtpJuniortravelmode = "travelmode";
    public static final String colMtpJuniorfromBeat = "frombeat";
    public static final String colMtpJuniortoBeat = "tobeat";
    public static final String colMtpJuniorpersonId = "personid";
    public static final String colMtpJuniorpersonName = "personname";
    public static final String colMtpJuniortravelDistance = "traveldistance";
    public static final String colMtpJuniorTime = "time";
    public static final String colMtpJuniorapproved = "approved";
    public static final String colMtpJuniorrejected = "reject";
    public static final String colMtpJuniorremarks = "remarks";


    public static final String createMtp_junior_table = "create table mtpjuniordata(_id INTEGER primary key ,"
            + "date TEXT,"
            + "current_date TEXT,"
            + "dealer TEXT,"
            + "month TEXT,"
            + "totalcall TEXT,"
            + "totalsale TEXT,"
            + "superstockist TEXT,"
            + "travelmode TEXT,"
            + "frombeat TEXT,"
            + "tobeat TEXT,"
            + "personid TEXT,"
            + "personname TEXT,"
            + "traveldistance TEXT,"
            + "time TEXT,"
            + "approved TEXT,"
            + "reject TEXT,"
            + "remarks TEXT,"
            + "delete_status Integer DEFAULT 0)";

    //Table For Showing Recommended SKU For Users:-
    public static final String RecommendedSKU = "RecommendedSKU";
    public static final String recommended_Id = "p_id";
    public static final String Quantity = "quantity";
    public static final String FromDate = "fromDate";
    public static final String ToDate = "toDate";

    public static final String RecommendedSKUForRetailers = "create table RecommendedSKU(id INTEGER primary key Autoincrement ,"
            + "p_id TEXT,"
            + "quantity TEXT,"
            + "fromDate DATE,"
            + "toDate DATE,"
            + "delete_status TEXT);";

    //Table For Showing Recommended SKU For Users:-
    public static final String TownNameList = "town_name_list";
    public static final String TOWN_ID = "town_id";
    public static final String TOWN_NAME = "town_name";

    public static final String TownNameListTable = "create table town_name_list(id INTEGER primary key Autoincrement ,"
            + "town_id TEXT,"
            + "town_name TEXT,"
            + "delete_status INTEGER DEFAULT 0);";


    public static final String DailyExpense_junior_table = "dailyjuniordata";


    public static final String colDailyExpenseJuniorId = "_id";
    public static final String colDailyExpenseJuniorDate = "date";
    public static final String colDailyExpenseJuniorCurrentDate = "current_date";
    public static final String colDailyExpenseJuniordealerid = "dealer";
    public static final String colDailyExpenseJuniormonth = "month";
    public static final String colDailyExpenseJuniortotalcalls = "totalcall";
    public static final String colDailyExpenseJuniortotalsales = "totalsale";
    public static final String colDailyExpenseJuniorsuperstockistname = "superstockist";
    public static final String colDailyExpenseJuniortravelmode = "travelmode";
    public static final String colDailyExpenseJuniorfromBeat = "frombeat";
    public static final String colDailyExpenseJuniortoBeat = "tobeat";
    public static final String colDailyExpenseJuniorpersonId = "personid";
    public static final String colDailyExpenseJuniorpersonName = "personname";
    public static final String colDailyExpenseJuniortravelDistance = "traveldistance";
    public static final String colDailyExpenseJuniorTime = "time";
    public static final String colDailyExpenseJuniorapproved = "approved";
    public static final String colDailyExpenseJuniorrejected = "reject";
    public static final String colDailyExpenseJuniorremarks = "remarks";


    public static final String createDailyExpense_junior_table = "create table dailyjuniordata(_id INTEGER primary key ,"
            + "date TEXT,"
            + "current_date TEXT,"
            + "dealer TEXT,"
            + "month TEXT,"
            + "totalcall TEXT,"
            + "totalsale TEXT,"
            + "superstockist TEXT,"
            + "travelmode TEXT,"
            + "frombeat TEXT,"
            + "tobeat TEXT,"
            + "personid TEXT,"
            + "personname TEXT,"
            + "traveldistance TEXT,"
            + "time TEXT,"
            + "approved TEXT,"
            + "reject TEXT,"
            + "remarks TEXT,"
            + "delete_status Integer DEFAULT 0)";

    public static final String SalesHeadNotifiTable = "SalesHeadNotificationTable";
    public static final String colSalesHeadNotifiid = "SalesHeadNotifiid";
    public static final String colSalesHeadNotifiFullName = "SalesHeadNotifiFullName";
    public static final String colSalesHeadNotifiDate = "SalesHeadNotifiDate";
    public static final String colSalesHeadNotifiEmpCode = "SalesHeadNotifiEmpCode";
    public static final String colSalesHeadNotifiRoleName = "SalesHeadNotifiRoleName";
    public static final String colSalesHeadNotifiSenior = "SalesHeadNotifiSenior";
    public static final String colSalesHeadNotifiMobile = "SalesHeadNotifiMobile";

    public static final String colSalesHeadNotifiSalesHead = "SalesHeadNotifiSalesHead";
    public static final String colSalesHeadNotifiCheckIn = "SalesHeadNotifiCheckIn";
    public static final String colSalesHeadNotifiCheckOut = "SalesHeadNotifiCheckOut";
    public static final String createSalesHeadNotifi = "create table SalesHeadNotificationTable(SalesHeadNotifiid Integer primary key Autoincrement,"
            + "SalesHeadNotifiFullName TEXT,"
            + "SalesHeadNotifiDate TEXT,"
            + "SalesHeadNotifiEmpCode TEXT,"
            + "SalesHeadNotifiRoleName TEXT,"
            + "SalesHeadNotifiSenior TEXT,"
            + "SalesHeadNotifiMobile TEXT ,"
            + "SalesHeadNotifiSalesHead TEXT,"
            + "SalesHeadNotifiCheckIn TEXT ,"
            + "SalesHeadNotifiCheckOut TEXT,"
            + "delete_status Integer DEFAULT 0)";
    public static final String time = "time";
    public static final String remark = "remark";
    public static final String current_date = "current_date";
    public static final String daily_totalvalue = "daily_totalvalue";
    public static final String dsr_id = "dsr_id";
    public static final String latitude = "latitude";
    public static final String longitude = "longitude";
    public static final String mcc_mnc_lac_cellId = "mcc_mnc_lac_cellId";
    public static final String override = "override";

    public static final String Daily_Sales_Report_table = "create table Daily_Sales_Report(dsr_id INTEGER primary key autoincrement,"
            + "distributor TEXT,"
            + "location TEXT,"
            + "daily_totel_call INTEGER,"
            + "daily_total_prod INTEGER,"
            + "time TEXT,"
            + "remark TEXT,"
            + "current_date TEXT,"
            + "daily_totalvalue INTEGER,"
            + "latitude TEXT,"
            + "longitude Text,"
            + "override Text,"
            + "mcc_mnc_lac_cellId Text,"
            + "delete_status Integer DEFAULT 0);";

    // Tracking Time
    public static final String SYNC_TRACKING_DETAILS = "track_location";

    // For Primary Sale
    public static final String Primary_Sale = "Primary_Sale";
    public static final String Distributor_Counter_Sale = "Distributor_Counter_Sale";
    public static final String counter_sale_total_value = "counter_sale_total_value";


    public static final String RETAILER_BALANCE_STOCK = "retailerbalancestock";
    public static final String primary_total_value = "primary_total_value";
    public static final String retailer_total_value = "retailer_total_value";

    // For Daily Expense
    public static final String SYNC_EXPENSE = "daily_report_store_table";

    // For Balance Stock
    public static final String Balance_Stock = "Balance_Stock";

    public static final String Compittior_Table = "Compittior_Table";
    // For Geo Fancing Table
    public static final String GEO_FANCING_TABLE = "geo_fancing_table";
    // for Geo Fancing Time Details Table
    public static final String GEOFANCING_TIME_DATAILS_TABLE = "geofancing_timedetails_table";

    // For CallWise NotConnected Reason
    public static final String SYNC_CallWiseReason = "reason";

    // For Damage-Product Table
    public static final String Damage_Product = "Damage_Product";
    public static final String RETAILER_SCHEME_ANNUAL_BONDING = "RETAILER_SCHEME_ANNUAL_BONDING";
    // /////////////////////////////////////

    // /Login Query
   /* private static final String user_pass_query = "insert into "
            + LOGIN_USERNAME_INSERT
            + " (user,pass,imei,user_id) values (?,?,?,?)";
*/
    private static final String travelling_query = "insert into "
            + LOGIN_TRAVELLINGMODE + " (id,travelling_mode_names) values (?,?)";

    private static final String track_time = "insert into "
            + LOGIN_TRACKINGTIME_MASTER + " (t1,status) values (?,?)";

    // Damage Replace Query

    private static final String damage_replace_query = "insert into "
            + SYNC_DAMAGE_REPLACE_TABLE
            + " (d_code,l_code,c_code,reason_exc,p_code,p_qty,p_mrp,p_value,orderid,damage_value,time,date,imei,returnVal) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";// for
    // Complaint Query

    private static final String complaint_insert_query = "insert into "
            + SYNC_Complaint_Table
            + "( imei, date, time, feedback_from, complaint_type, dealer_retailer_id, message, image, order_id, role_id, name, contact) values (?,?,?,?,?,?,?,?,?,?,?,?)";

    // //////////////////////////////////////////

    // ////Attandace Query///////////////

    /* private static final String atten_insert_query = "insert into "
             + ATTENDANCE_STORETABEL
             + " (attn_id,work_status,remark,attn_time,attn_date,imei,lat,lng,check_mcc_mnc_lac_cellId, image, orderid,location, working_with,daily_newsearching,daily_workingwith,daily_remark,delete_status,daily_status,images_status,leave_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";*/
    // For CallWise Image Insert Query
    private static final String callwise_img_insert_query = "insert into "
            + SYNC_CALLWISE_IMAGE
            + " (c_code,c_img,l_id,time,imei,date) values (?,?,?,?,?,?)";
    // Retailer Creation Query

    private static final String cust_creation_insert_query = "insert into "
            + SYNC_CREATE_RETAILER_TABLE
            + " (retailer_id,d_code,l_code,c_name,contact_name,c_mob,create_date,create_time,imei,pin,e_mail,outlettype,tin,lat,longi,imagename,mcc_mnc_lac_cellId,adres_str,customer_type,seq_no,geo_add,battery_status,gps_status) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    // Retailer Image Insertion Query

    private static final String cust_img_insert_query = "insert into "
            + SYNC_RETAILER_IMAGE_TABLE
            + " (retailer_id,c_img,l_id,time,imei,date) values (?,?,?,?,?,?)";
    // For Daily Expense
    /*private static final String daily_report_insert_query = "insert into "
            + SYNC_EXPENSE
            + " (t_mode,str_jrny,end_jrny,total_calls,ta_exp,da_exp,misc_exp,total_exp,daily_report_date,time"
            + ",imei, orderid,image, image2, image3, other_postage, other_telecom ,lat,longitude,address,mcc_mnc_lac_cellId,hotelrent,b_code,remarks,date) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";// for*/
    // Daily Expense Image
   /* private static final String img_insert_daily_expense_query = "insert into "
            + SYNC_DAILYEXPENCE_IMAGE
            + " (image,time,imei,date, orderid,image2,image3) values (?,?,?,?,?,?,?)";
*/
    private static final String track_query = "insert into "
            + SYNC_TRACKING_DETAILS
            + " (track_date,track_time,lat,lng,imei,mcc_mnc_lac_cellId,location) values (?,?,?,?,?,?,?)";


    // Retailer Location
//    private static final String retailer_location = "INSERT INTO "
//            + RETAILER_LOCATION_TABLE
//            + " (retailer_id TEXT, new_lat TEXT, new_long TEXT) values (?,?,?)";

    // /////////////////////

    public DataBaseManipulate(Context context) {
        DataBaseManipulate.context = context;
//        if (objDataBaseHelper != null) {
//            objDataBaseHelper.close();
//        }

        objDataBaseHelper = DataBaseHelper.getInstance(DataBaseManipulate.context);

        DataBaseManipulate.objSqliteDB = DataBaseHelper.getInstance(DataBaseManipulate.context)
                .getWritableDatabase();

//        if (objSqliteDB.isDbLockedByCurrentThread()) {
//            objSqliteDB.endTransaction();
//
////            DataBaseManipulate.objSqliteDB = objDataBaseHelper.getWritableDatabase();
//
//        }


//        if (DataBaseManipulate.objSqliteDB.isReadOnly()) {

        // LOGIN/////////////////////////////

       /* this.user_pass = DataBaseManipulate.objSqliteDB
                .compileStatement(user_pass_query);*/
        this.travelling_mode_statement = DataBaseManipulate.objSqliteDB
                .compileStatement(travelling_query);

        this.track_time_insert = DataBaseManipulate.objSqliteDB
                .compileStatement(track_time);

        // //////////////////////

        // /////////Attandance///////////
       /* this.atten_insert = DataBaseManipulate.objSqliteDB
                .compileStatement(atten_insert_query);*/
        // ////
        // for Damge Replace
        this.damage_replace_insert = DataBaseManipulate.objSqliteDB
                .compileStatement(damage_replace_query);
        // for Complaint
        this.complaint_insert = DataBaseManipulate.objSqliteDB
                .compileStatement(complaint_insert_query);
        // for Gift Image Insertion
        this.callwise_img_insert = DataBaseManipulate.objSqliteDB
                .compileStatement(callwise_img_insert_query);
        // For Retailer Creation
        this.customer_store_insert = DataBaseManipulate.objSqliteDB
                .compileStatement(cust_creation_insert_query);
        // For Retailer Image Insertion
        this.cust_img_insert = DataBaseManipulate.objSqliteDB
                .compileStatement(cust_img_insert_query);
        // For Daily Expense
       /* this.daily_report_insert = DataBaseManipulate.objSqliteDB
                .compileStatement(daily_report_insert_query);*/
        // For img_insert_daily_expense
       /* this.img_insert_daily_expense = DataBaseManipulate.objSqliteDB
                .compileStatement(img_insert_daily_expense_query);*/
        // For Tracking
        this.track_statement = DataBaseManipulate.objSqliteDB
                .compileStatement(track_query);

//        if (DataBaseManipulate.objSqliteDB.inTransaction()) {
//            DataBaseManipulate.objSqliteDB.endTransaction();
//        }
//        if (objSqliteDB.inTransaction()) {
//            objSqliteDB.endTransaction();
//        }

//        }
//        if (objDataBaseHelper.getWritableDatabase().isDbLockedByCurrentThread()) {
//            if (objDataBaseHelper.getWritableDatabase().inTransaction()) {
//                objDataBaseHelper.close();
//            }
//        }


    }

    private static class DataBaseHelper extends SQLiteOpenHelper {

        private static DataBaseHelper sInstance;

        public static DataBaseHelper getInstance(Context context) {

            // Use the application context, which will ensure that you
            // don't accidentally leak an Activity's context.
            // See this article for more information: http://bit.ly/6LRzfx
            if (sInstance == null) {
                sInstance = new DataBaseHelper(context);
            }
            return sInstance;
        }

        /**
         * Constructor should be private to prevent direct instantiation.
         * make call to static factory method "getInstance()" instead.
         */
        DataBaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase objSQLiteDB) {


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_CONSTANT_DELETE
                            + "(id INTEGER PRIMARY KEY ," +
                            "role_id TEXT  ," +
                            "title Text ," +
                            "rolename Text ," +
                            "person_id Text," +
                            "person_fullname Text," +
                            "marital_status Text," +
                            "dob Text," +
                            "mobile Text," +
                            "gender Text," +
                            "doj Text," +
                            "emp_code Text ," +
                            "dept Text ," +
                            "email Text )");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_COURSE_TABLE
                            + " (t_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "id Text," +
                            "name Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_SUBJECT_TABLE
                            + " (t_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "id Text," +
                            "name Text," +
                            "paper_type_id Text,semester_id Text,Test Text,Assignment Text,Presentation Text,Lab Text)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_SEMESTER_TABLE
                            + " (t_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "id Text," +
                            "name Text," +
                            "subject_id Text)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_SECTION_TABLE
                            + " (t_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "id Text," +
                            "name Text," +
                            "semester_id Text,section_type Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_CLASS_TYPE_TABLE
                            + " (t_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "id Text," +
                            "name Text," +
                            "paper_type_id Text,sequence_id Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_CLASS_STUDENTS_DETAILS_TABLE
                            + " (t_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "paper_type_id Text," +
                            "course_id Text," +
                            "subject_id Text," +
                            "semester_id Text," +
                            "section_id Text," +
                            "student_id Text," +
                            "student_name Text," +
                            "college_roll Text)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + EDIT_STUDENT_ATTENDANCE_DATA
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "status Text," +
                            "update_count Text," +
                            "attendance_id Text," +
                            "total_held Text," +
                            "attended Text," +
                            "subject_id Text," +
                            "date Text," +
                            "college_roll Text," +
                            "student_id Text," +
                            "student_name Text)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_LEAVE_TYPE_TABLE
                            + " (t_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "id Text," +
                            "name Text," +
                            "short_name Text," +
                            "total_leave Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_ASSESSMENT_TYPE
                            + " (t_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "id Text," +
                            "name Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_PAPER_TYPE
                            + " (t_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "id Text," +
                            "name Text)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_PRIORITY_MASTER_TYPE
                            + " (t_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "id Text," +
                            "name Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_DEPARTMENT_MASTER_TYPE
                            + " (t_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "id Text," +
                            "name Text)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_TIME_PERIOD_TYPE
                            + " (t_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "id Text," +
                            "name Text," +
                            "start_time Text," +
                            "end_time Text)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + TAKE_STUDENT_ATTENDANCE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "attendence_id Text," +
                            "attendence_date Text," +
                            "attendence_status Text," +
                            "attendence_total_held Text," +
                            "semester_id Text," +
                            "lecture_attended Text," +
                            "sub_id Text," +
                            "section_id Text," +
                            "student_id Text," +
                            "course_id Text," +
                            "attendence_time Text," +
                            "attendence_created_datetime Text," +
                            "class_type_id Text," +
                            "delete_status INTEGER DEFAULT 0)");

            objSQLiteDB.execSQL("CREATE TABLE "
                    + lasttimesyncdateandtime
                    + " (id INTEGER PRIMARY KEY AUTOINCREMENT, date Text,time Text)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_DEALER_TABLE
                            + " (t_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "id Text," +
                            "DealerName Text," +
                            "ss_id Text, town_id Text ," +
                            "town_name Text ," +
                            "delete_status INTEGER DEFAULT 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE " + LOGIN_BEAT_TABLE
                            + " (b_code INTEGER PRIMARY KEY ," +
                            "b_name Text," +
                            "dis_id Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_LOCATION_TABLE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "l_code Text ," +
                            "l_name Text," +
                            "dis_id Text)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_RETAILER_TABLE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "address Text," +
                            "geo_add Text," +
                            "l_name Text," +
                            "last_visit_date Text," +
                            "created_at Text," +
                            "created_by Text," +
                            "created_designation Text," +
                            "email Text," +
                            "tin Text," +
                            "lat Text," +
                            "lng Text," +
                            "contactno Text," +
                            "contactperson Text," +
                            "c_code Text," +
                            "c_name Text," +
                            "l_id Text," +
                            "d_id Text," +
                            "cust_number Text," +
                            "total_sale Text," +
                            "last_amt Text," +
                            "last_date Text," +
                            "outstanding Text," +
                            "achieved Text," +
                            "seq_no Text," +
                            "delete_retailer_status TEXT, " +
                            "current_date Text, " +
                            "current_time Text, " +
                            "cCom Integer default 1)");

            objSQLiteDB.execSQL(createUserColleague);


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_APP_MODULE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "module_icon_image Text ," +
                            "module_id Text," +
                            "module_name Text," +
                            "module_url Text)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_OTHER_APP_MODULE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "other_module_icon_image Text ," +
                            "other_module_id Text," +
                            "other_module_name Text)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_SUB_APP_MODULE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "module_id Text ," +
                            "sub_module_name Text," +
                            "sub_module_id Text," +
                            "sub_module_url Text," +
                            "sub_module_icon_image Text)");

            objSQLiteDB
                    .execSQL(createWorkingStatus);

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_URL_LIST
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "code Text ," +
                            "url_list Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_Classification_TABLE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "class_id Text," +
                            "class_name Text)");

            objSQLiteDB
                    .execSQL(" CREATE TABLE "
                            + LOGIN_PRODUCT_CATAGORY_TABLE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT , " +
                            "category_id Text," +
                            "category_name Text," +
                            "classification_name Text," +
                            "classification_id Text," +
                            "delete_status INTEGER DEFAULT 0)");

            objSQLiteDB
                    .execSQL(createProductTable);

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_PRODUCT_TABLE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,tax Text," +
                            "p_code Text," +
                            "p_name Text," +
                            "scheme Text," +
                            "scheme_qty Text," +
                            "focus Text," +
                            "p_value Text," +
                            "unit Text," +
                            "mrp Text," +
                            "classification_id Text," +
                            "classification_name Text," +
                            "focus_target Text," +
                            "categoryid Text," +
                            "pcs_mrp Text," +
                            "casevalue Text," +
                            "prefpreference_id Text," +
                            "categoryname Text," +
                            "dealer_rate   Text," +
                            "dealer_pcs_rate   Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_STATE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "state_id Text ," +
                            "state_name Text)");

            objSQLiteDB.execSQL(createUserTown);


            objSQLiteDB.execSQL("CREATE TABLE "
                    + TABLE_CLOSE_THE_DAY
                    + " (id INTEGER PRIMARY KEY AUTOINCREMENT,new_outlets_opened_today Text, remarks_on_NPD_sales Text,remarks_on_competitor_activity Text,any_suggestion_to_the_company Text,check_in_lat Text,check_in_long Text,currentDate Text,currentTime Text,check_mcc_mnc_lac_cellId Text,location Text,unique_id Text, delete_status Integer default 0)");

            //market
            objSQLiteDB.execSQL("CREATE TABLE "
                    + TABLE_REPORT1
                    + " (id INTEGER PRIMARY KEY AUTOINCREMENT, report_id Text,que1 Text,que2 Text,que3 Text,report_time Text,report_date Text,imei Text,lat Text,lng Text,check_mcc_mnc_lac_cellId Text, image Text, orderid Text,location Text,time_stamp Text,delete_status Integer default 0,images_status Integer default 0)");

            objSQLiteDB.execSQL("CREATE TABLE "
                    + TABLE_REPORT2
                    + " (id INTEGER PRIMARY KEY AUTOINCREMENT, report_id Text,que1 Text,que2 Text,que3 Text,report_time Text,report_date Text,imei Text,lat Text,lng Text,check_mcc_mnc_lac_cellId Text, image Text, orderid Text,location Text,time_stamp Text,delete_status Integer default 0,images_status Integer default 0)");


            objSQLiteDB.execSQL("CREATE TABLE "
                    + Comment_new_Table
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " gate_meeting_summary Text," +
                    " new_ideas Text," +
                    " ss Text," +
                    " distributor Text," +
                    " market text," +
                    " damage Text," +
                    " competitors Text," +
                    " pjp Text," +
                    " outlet text," +
                    " sale_outlet text," +
                    " image text," +
                    " image2 text," +
                    " image3 text," +
                    " orderid Text," +
                    " date Text," +
                    " time Text," +
                    " delete_status Integer default 0," +
                    " images_status Integer default 0)");

            // Create GeneralTrade Meeting
            objSQLiteDB.execSQL(GENERAL_TRADE_MEETINGS_TABLE);

            // Create ModernTrade Meeting
            objSQLiteDB.execSQL(MODERN_TRADE_MEETINGS_TABLE);

            // User Colleague


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + RETAILER_SCHEME_DISCOVERY_OUTLET
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, retailer_id TEXT, status TEXT, date TEXT, time TEXT,battery_status Text,gps_status Text, orderId Text,delete_status Integer DEFAULT 0)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + RETAILER_SCHEME_ANNUAL_BONDING
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, retailer_id TEXT, status TEXT, date TEXT, time TEXT,battery_status Text,gps_status Text, orderId Text,delete_status Integer DEFAULT 0)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + CHECK_FOR_UPDATE_DATA
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, update__data_status Integer default 0 )");

            // Login Activity Tables

            objSQLiteDB.execSQL(createRetailerReshuffle);
            objSQLiteDB.execSQL(EssQuestionSurveyTable);
            objSQLiteDB.execSQL(RecommendedSKUForRetailers);
            objSQLiteDB.execSQL(ReportingManagerDetailsTable);
            objSQLiteDB.execSQL(RetailerTableNew);
            objSQLiteDB.execSQL(TownNameListTable);
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_USERDETAIL
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, user Text,pass Text,imei Text)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_RETAILER_TARGET_BEAT
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,target_id Text,value Text,value_to Text, scheme_gift Text,start_date Text,end_date Text,achieved Text,status Text,delete_status Integer DEFAULT 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + RETAILER_TARGET_BEAT2
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, start_date Text,end_date Text,status Text,retailer_id Text,delete_status Integer DEFAULT 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_RETAILER_ACHEIVEMENT
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, value Text,value_to Text,scheme_gift Text,start_date Text,end_date Text,acheived Text)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SHARE_INFORMATION_COUNT
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, count Text,date Text,delete_status Integer DEFAULT 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + Merchandise_TABLE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,orderid Text,image Text,gps_status Text,battery_status Text, merchandise_id Text,retailerid Text,merchandise_date Text,merchandise_time Text,merchandise_name Text,text1 Text,delete_status Integer DEFAULT 0,lat Text,lngi Text,address Text,mcc_mnc_lac_cellid Text,images_status Integer Default 0)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + COMPETITION_NEW_PRODUCT_LAUNCH_REPORT
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,orderid Text,town_area Text," +
                            " launch_date Text,product_and_brand_name Text,sddcsacf Text,marketed_by Text," +
                            "address Text,town Text,district Text," +
                            "state Text,pincode Text,weight Text," +
                            "nature_of_inner_packaging Text,nature_of_outer_packaging Text,brand Text," +
                            "weight_pricing Text,mrp Text,being_sold_to_consumer Text," +
                            "before_trade_scheme Text,trade_scheme Text,after_trade_scheme Text," +
                            "units_per_case_bag Text,pan_card_date Text,net_cost_price_to_retailer Text," +
                            "retailer_margin_per_unit Text,consumer_scheme Text,must_enclose_cash_memo Text," +
                            "must_enclose_cash_memo_date Text,advertising_support Text,pop_material_send_sample Text," +
                            "outlet_covered Text,samples_must_send Text,comments Text," +
                            "cur_date Text,cur_time Text,must_enclose_if_any Text," +
                            "latitude Text,longitude Text,gps_status Text,battery_status Text,location Text,mcc_mnc_lac_cellid Text,user_id Text," +
                            "delete_status Integer DEFAULT 0,images_status Integer Default 0)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + DAILY_PROSPECTING_WORK
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,orderid Text,party_name Text," +
                            " party_address Text,battery_status Text,gps_status Text,phone_no Text,mobile_no Text,email_id Text," +
                            "residence_phone Text,person_met_and_status Text,established_since Text," +
                            "annual_turn_over Text,reputation_trade_relation Text,financial_position Text," +
                            "level_ofinterst Text,from_time Text,to_time Text," +
                            "units_availble_and_qty Text,gst_no Text,gst_registrtion_date Text," +
                            "assured_investment Text,term_and_condition Text,stockiest_filled_from Text," +
                            "pan_card_no Text,pan_card_date Text,godown_size Text," +
                            "no_of_employee Text,comments Text,cur_date Text,cur_time Text," +
                            "latitude Text,longitude Text,location Text,mcc_mnc_lac_cellid Text,user_id Text,town Text,district Text,state Text," +
                            "delete_status Integer DEFAULT 0,images_status Integer Default 0)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + Merchandise_REQUIREMTENT_TABLE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,orderid Text,battery_status Text,gps_status Text,image Text, merchandise_id Text,retailerid Text,merchandise_date Text,merchandise_time Text,merchandise_name Text,text1 Text,delete_status Integer DEFAULT 0,remarks Text,images_status Integer Default 0)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + RETAILER_LOCATION_TABLE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,battery_status Text,gps_status Text, retailer_id TEXT, geo_add Text, new_lat TEXT, new_long TEXT, contactperson Text,email Text, contactno Text, mccMncLacCellId Text, address Text, delete_status Integer DEFAULT 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_ISRUSER_TABLE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, isr_id Text, dealerisr_id Text, dealerisr_name Text, isrname Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_PERCENTSCHEME_TABLE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,scheme_name Text,start_date Text,end_date Text,value Text,value_to Text,scheme_per Text)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_Gift
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,g_id Text,g_name Text)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + EDIT_INFORMATION
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, e_id Text,e_id1 Text, m_id Text, delete_status Integer DEFAULT 0)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_PRODUCT_Stock
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,p_id Text,d_id Text,lat Text,lng Text,stock_qty Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_JUNIORUSER_TABLE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,j_id Text,checkintime Text,d_id text,d_name Text,j_name Text,checkouttime Text,ciremarks Text,coremarks Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_JUNIORUSER_Checkin
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,j_id Text,checkintime Text,ciremarks Text,date Text,delete_status Integer DEFAULT 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_JUNIORUSER_Checkout
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,j_id Text,checkintime Text,coremarks Text,date Text, delete_status Integer DEFAULT 0)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_DAMAGEPRODUCT_TABLE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,p_code INTEGER,p_name Text,rate Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + COUNT_TABLE_NOTI
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,count Text)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + NEW_TRACKING
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, mcc_mnc_cell_id Text ,gps_status Text,battery_status Text,lati Text,longi Text,location Text,date Text,time Text,delete_status Integer default 0)");

            objSQLiteDB
                    .execSQL(createTravellingMode);


            objSQLiteDB
                    .execSQL(createFlightModeOnOffTable);
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_DAMAGEPRODUCT_CATAGORY_TABLE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,category_id Text,category_name Text)");


            objSQLiteDB.execSQL("CREATE TABLE " + LOGIN_DAILY_REPORTING
                    + " (id INTEGER PRIMARY KEY," + new_searching + " Text)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + PAYMENT_RECEIVED_DETAILS
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, zone_name Text," +
                            " username Text,emp_id Text, user_hq Text , user_designation Text , distributor_id Text , " +
                            "town Text , payment_mode_id Text , number Text , payment_received_date Text , amount Text ," +
                            "drawn_from_bank Text , deposited_bank Text , deposited_date Text , latitude Text , longitude Text , " +
                            "geo_address Text ,gps_status Text,battery_status Text, curr_date Text , curr_time Text , unique_id Text , order_id Text , " +
                            "image_name Text , mcc_mnc Text , user_id, delete_status INTEGER DEFAULT 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + PAYMENT_RECEIVED_RETAILER
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, zone_name Text," +
                            " username Text,emp_id Text, user_hq Text , user_designation Text , distributor_id Text, beat_id Text, retailer_id Text, " +
                            "town Text , payment_mode_id Text , number Text , payment_received_date Text , amount Text ," +
                            "drawn_from_bank Text , deposited_bank Text , deposited_date Text , latitude Text , longitude Text , " +
                            "geo_address Text , curr_date Text , curr_time Text , unique_id Text , order_id Text , " +
                            "image_name Text , mcc_mnc Text , delete_status INTEGER DEFAULT 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + Distributor_Counter_Sale
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + "counter_sale_current_date Text, counter_sale_current_time Text,counter_sale_dealer_name Text, counter_sale_dealer_id Text, "
                            + "counter_sale_product_name Text, counter_sale_cases Text, counter_sale_pieces Text, counter_sale_pro_case_value Text, "
                            + counter_sale_total_value
                            + " Text, "
                            + "counter_sale_catagory_id Text,battery_status Text,gps_status Text, counter_sale_catagory_name Text, counter_sale_product_code Text, counter_sale_order_id Text, "
                            + "counter_sale_grpId_childId Text,counter_sale_mcc_mnc_cell_lacId Text,counter_sale_rate Text,counter_sale_scann Text, counter_sale_order_status Text default false, value_str Text, case_rate Text, pcs_rate Text, delete_status Integer default 0, schemeQty TEXT, lat Text, lng Text, address Text)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_COMPLAINT_TABLE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, com_Id Text, com_name Text, delete_status Integer default 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_NON_PRODUCTIVE
                            + "(non_id INTEGER PRIMARY KEY AUTOINCREMENT, id Text, name Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_RETURN_REASON_TYPE
                            + "(return_id INTEGER PRIMARY KEY AUTOINCREMENT, id Text, name Text)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_FEEDBACK_TABLE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, feed_Id Text, feed_name Text, delete_status Integer default 0)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_PAYMENT_MODE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, payment_id Text, mode Text, delete_status Integer default 0)");


            objSQLiteDB.execSQL("CREATE TABLE " + LOGIN_ISR_TABLE
                    + " (id INTEGER PRIMARY KEY, DealerName  Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_OUTLETS
                            + " (t_id INTEGER PRIMARY KEY AUTOINCREMENT, id Text,outlet_names Text)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_MTP_DATA
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, m_id Text,date Text," +
                            "today Text,today_id Text , rd Text)");

            objSQLiteDB.execSQL("CREATE TABLE " + LOGIN_TASK_OF_THE_DAY
                    + " (id INTEGER PRIMARY KEY ,task_id Text, name Text)");
            objSQLiteDB.execSQL("CREATE TABLE " + LOGIN_OWNERSHIPTYPE
                    + " (id INTEGER PRIMARY KEY , ownership_type Text)");


            objSQLiteDB.execSQL("CREATE TABLE " + LEAVE_TYPE
                    + " (id INTEGER PRIMARY KEY , leave_id Text,leave_name Text, leave_value Text)");


            objSQLiteDB.execSQL("CREATE TABLE " + USER_IMAGE
                    + " (id INTEGER PRIMARY KEY , user_id Text,image Text)");

            objSQLiteDB.execSQL("CREATE TABLE " + SCHEME_TYPE
                    + " (id INTEGER PRIMARY KEY , scheme_id Text,p_id Text,buy_quantity Text,schm_quantity Text,start_date Text,end_date Text)");


            objSQLiteDB.execSQL("CREATE TABLE " + LOGIN_TRAVELLINGMODE
                    + " (id INTEGER PRIMARY KEY , travelling_mode_names Text)");

            objSQLiteDB.execSQL("CREATE TABLE " + LOGIN_ROLE
                    + " (id INTEGER PRIMARY KEY, role Text)");
            objSQLiteDB.execSQL("CREATE TABLE " + LOGIN_ROLE1
                    + " (id INTEGER PRIMARY KEY,r_id Text, role Text)");
            objSQLiteDB.execSQL("CREATE TABLE " + LOGIN_FIELDEXPERINCE
                    + " (id INTEGER PRIMARY KEY, filed_experience Text)");

            objSQLiteDB.execSQL("CREATE TABLE " + LOGIN_ATTENDANCE_STATUS
                    + " (id INTEGER PRIMARY KEY," + attn_status + " Text)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_MARKETGIFT
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT ,gift_id Text, gift Text)");

            objSQLiteDB.execSQL("CREATE TABLE " + LOGIN_MARITIAL_STATUS
                    + " (id INTEGER PRIMARY KEY , marital_status Text)");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_USERNAME_INSERT
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, user Text,pass Text,imei Text,user_id Text)");

            objSQLiteDB.execSQL("CREATE TABLE " + LOGIN_CONSTANT_TRACKING
                    + "(id INTEGER PRIMARY KEY  ,time Text default 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_TRACK_INTERNET
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, date Text,time Text,delete_status Integer default 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_TRACKINGTIME_MASTER
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, t1 Text,status Integer)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_DEALER_SALE_TABLE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, d_code Text,d_name Text,l_code Text,l_name Text,p_code Text,p_name Text)");

            objSQLiteDB.execSQL("CREATE TABLE " + LOGIN_TRACKING_STANDERDTIME
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT, t1 Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + phone_status
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT ,date Text ,time Text ,status Text ,delete_status Integer default 0)");

            objSQLiteDB.execSQL(createTotalFulFillmentTable);

            objSQLiteDB.execSQL(CreateCallWiseReportingtable);
            objSQLiteDB.execSQL(createTotalFulFillmentTable1);
            objSQLiteDB.execSQL(createDailyReportingTable);
            objSQLiteDB.execSQL(EmployeeDataGetting);
            objSQLiteDB.execSQL(SuggestionGettingDataTable);

            objSQLiteDB.execSQL(createAppDelivery_TABLE);
            objSQLiteDB.execSQL(createCounterSale_TABLE);
            objSQLiteDB.execSQL(LOGIN_check_status_tabel);
            objSQLiteDB.execSQL(Root_Plan_table);
            objSQLiteDB.execSQL(createMtp_junior_table);
            objSQLiteDB.execSQL(createDailyExpense_junior_table);
            objSQLiteDB.execSQL(createSalesHeadNotifi);
            objSQLiteDB.execSQL(Payment_Collection_Data_table);


            objSQLiteDB.execSQL(Payment_Collection_Data_Distributor_table);
            objSQLiteDB.execSQL(Daily_Sales_Report_table);
            objSQLiteDB.execSQL(createFullfillmentReportRetailerTable);
            objSQLiteDB.execSQL(createFullfillmentReportProductTable);
            objSQLiteDB.execSQL(createFulFillmentReportTotalTable);
            objSQLiteDB.execSQL(createOutletTypeTable);

            objSQLiteDB.execSQL(createOutletCategoryTable);

            objSQLiteDB.execSQL("CREATE VIEW " + viewRootPlan + " AS SELECT "
                    + DataBaseManipulate.Root_plan_s + "."
                    + DataBaseManipulate.Root_plan_id + " AS _id," + " "
                    + DataBaseManipulate.Root_plan_s + "."
                    + DataBaseManipulate.date_s + "," + " "
                    + DataBaseManipulate.Root_plan_s + "."
                    + DataBaseManipulate.distributor_s + "," + " "
                    + DataBaseManipulate.Root_plan_s + "."
                    + DataBaseManipulate.beat_s + "," + " "
                    + DataBaseManipulate.Root_plan_s + "."
                    + DataBaseManipulate.Total_call_s + "," + " "
                    + DataBaseManipulate.pc + "," + " "
                    + DataBaseManipulate.Root_plan_s + "."
                    + DataBaseManipulate.del_status + "" + " FROM "
                    + DataBaseManipulate.Root_plan_s);

            // ///Attandace Execute TAble////////////////
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + ATTENDANCE_STORETABEL
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + " attn_id Text,battery_status Text,gps_status Text,work_status Text,remark Text,attn_time Text,attn_date Text,imei Text,lat Text,"
                            + " lng Text,check_mcc_mnc_lac_cellId Text, image Text, orderid Text,location Text, working_with Text,"
                            + " delete_status Text,images_status Text,daily_newsearching Text,daily_workingwith Text,daily_remark Text,daily_status Text, leave_id Text,colleague_id TEXT)");
            // ////////////////////////////////
            /* All Sync Table Creation */

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_CHECKOUT_TABLE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT  ,gps_status Text,battery_status Text,imei Text,date Text,lat Text,loc Text,time Text,check_out Text,remarks Text,order_id Text,total_call Text,total_productive_call Text,total_sale_value Text, delete_status Integer default 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_ISR_Detail
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + "isr_date Text, product_name Text,"
                            + " product_qty Text, price_value Text,calculate_value Text, dealer_id Text, isr_sale_value Text, total_call Text,"
                            + " Productive_call Text, isr_group_id Text, isr_child_id Text, product_category Text, isr_order_id Text, isr_orderstatus TEXT default false ,"
                            + "delete_status Integer default 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_DAMAGE_REPLACE_TABLE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, d_code Text, l_code Text, c_code Text, reason_exc Text, p_code Text, p_qty Text, p_mrp Text, p_value Text, orderid Text, damage_value Text, time Text, date Text, imei Text, returnVal Text,mobid INTEGER,delete_status Integer default 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_Complaint_Table
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, imei Text, "
                            + "date Text, time Text, feedback_from text, complaint_type Text, dealer_retailer_id Text, message Text, image text, order_id Text, role_id Text, name text, contact text, delete_status Integer default 0, images_status Integer default 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_BALANCESTOCK_TABLE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT  ,prodcode Text,product_name Text,qty Text,dealer_id Text,selectdate Text,orderid Text,mfgdate Text, delete_status Integer default 0)");

            objSQLiteDB.execSQL("CREATE TABLE " + SYNC_balance_report_userTable
                    + " (" + balance_report_userTable_id
                    + "  INTEGER PRIMARY KEY, " + "" + balance_report_userid
                    + " Text , " + balance_report_username + " Text, "
                    + balance_report_dealerid + " Text, " + ""
                    + balance_report_dealername + " Text, "
                    + balance_report_designation + " Text,"
                    + balance_report_sku_scheme
                    + "Text, delete_status Integer default 0 )");

            objSQLiteDB.execSQL("CREATE VIEW Report_balance_USER"
                    + " AS SELECT "
                    + SYNC_balance_report_userTable
                    + "."
                    + balance_report_userTable_id
                    + " AS _id,"
                    + " "
                    + SYNC_balance_report_userTable
                    + "."
                    + balance_report_userid
                    + ","
                    + " "
                    + SYNC_balance_report_userTable
                    + "."
                    + balance_report_username
                    + ","
                    + " "
                    + SYNC_balance_report_userTable
                    + "."
                    + balance_report_dealerid
                    + ","
                    + " "
                    + SYNC_balance_report_userTable
                    + "."
                    + balance_report_dealername
                    + ","
                    + " "
                    + SYNC_balance_report_userTable
                    + "."
                    + balance_report_designation
                    + ""
                    + " FROM "
                    + SYNC_balance_report_userTable);

            objSQLiteDB.execSQL("CREATE TABLE "
                    + SYNC_balance_report_sku_userTable + " ("
                    + balance_report_sku_userTable_id + " INTEGET PRIMARY KEY,"
                    + balance_report_sku_userid + " Text , "
                    + balance_sku_dealer_id + " Text , " + balance_manu_date
                    + " Text , " + balance_report_sku_productname + " Text, " +
                    balance_sku_order_id + " Text, "
                    + balance_report_sku_quantity + " Text, "
                    + balance_sku_today_date + " Text, "
                    + balance_report_sku_scheme + " Text)");

            objSQLiteDB.execSQL("CREATE VIEW Report_balance_SKU_USER"
                    + " AS SELECT "
                    + SYNC_balance_report_sku_userTable
                    + ". "
                    + balance_report_sku_userTable_id
                    + " AS _id,"
                    + " "
                    + SYNC_balance_report_sku_userTable
                    + "."
                    + balance_report_sku_userid
                    + ","
                    + " "
                    + SYNC_balance_report_sku_userTable
                    + "."
                    + balance_report_sku_productname
                    + ","
                    + " "
                    + SYNC_balance_report_sku_userTable
                    + "."
                    + balance_report_sku_quantity
                    + ","
                    + " "
                    + SYNC_balance_report_sku_userTable
                    + "."
                    + balance_report_sku_scheme
                    + ""
                    + " FROM "
                    + SYNC_balance_report_sku_userTable);


            objSQLiteDB.execSQL("CREATE TABLE " + SYNC_isrtempdatastore + " ("
                    + isr_pro_id + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + isr_pro_image + " TEXT,"
                    + isr_pro_current_date2 + " TEXT,"
                    + isr_pro_schemeqty + " TEXT, "
                    + isr_pro_remarks + " TEXT,"
                    + isr_pro_dealerid + " TEXT,"
                    + isr_pro_beatid + " TEXT,"
                    + isr_pro_retailerid + " TEXT,"
                    + isr_pro_retailer_name + " TEXT,"
                    + isr_pro_qty + " TEXT, "
                    + isr_pro_focus + " TEXT, "
                    + isr_pro_mrp + " TEXT, "
                    + isr_pro_baseprice + " TEXT, "
                    + isr_pro_scheme + " TEXT,"
                    + isr_pro_total_value + " TEXT, "
                    + isr_pro_rate + " TEXT, "
                    + isr_pro_group_id + " TEXT, "
                    + isr_pro_child_id + " TEXT, "
                    + isr_pro_child_name + " TEXT,"
                    + isr_pro_order_id + " TEXT,"
                    + isr_pro_latitude + " TEXT,"
                    + isr_pro_longitude + " TEXT, "
                    + isr_pro_uid + " TEXT,"
                    + isr_pro_category_name + " TEXT,"
                    + isr_pro_category_id + " TEXT,"
                    + isr_pro_discount + " TEXT,"
                    + isr_pro_finalamount + " TEXT,"
                    + isr_pro_classification_value + " TEXT,"
                    + isr_pro_mcc_mnc_lac + " TEXT,"
                    + isr_pro_current_date + " TEXT,"
                    + isr_pro_grpId_childId + " TEXT,"
                    + isr_pro_current_time + " TEXT,"
                    + isr_pro_imagename + " TEXT,"
                    + isr_pro_booked_order_type + " TEXT,"
                    + isr_pro_images_status + " TEXT default 0, "
                    + isr_pro_stock_value + " TEXT,"
                    + isr_pro_orderstatus
                    + " TEXT default false,delete_status Integer default 0)");

            objSQLiteDB.execSQL("CREATE TABLE " + SYNC_tempdatastore + " ("
                    + temp_pro_id + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + temp_pro_image + " TEXT,"
                    + temp_pro_current_date2 + " TEXT,"
                    + temp_pro_schemeqty + " TEXT, "
                    + temp_pro_remarks + " TEXT,"
                    + temp_pro_non_productive_id + " TEXT,"
                    + temp_pro_dealerid + " TEXT,"
                    + temp_pro_beatid + " TEXT,"
                    + temp_pro_retailerid + " TEXT,"
                    + temp_pro_retailer_name + " TEXT,"
                    + temp_pro_qty + " TEXT, "
                    + temp_pro_focus + " TEXT, "
                    + temp_pro_mrp + " TEXT, "
                    + temp_pro_distance_status + " TEXT, "
                    + temp_pro_distance + " TEXT, "
                    + temp_pro_baseprice + " TEXT, "
                    + temp_pro_scheme + " TEXT,"
                    + temp_pro_total_value + " TEXT, "
                    + temp_pro_rate + " TEXT, "
                    + temp_pro_group_id + " TEXT, "
                    + temp_pro_child_id + " TEXT, "
                    + temp_pro_child_name + " TEXT,"
                    + temp_pro_order_id + " TEXT,"
                    + temp_pro_latitude + " TEXT,"
                    + temp_pro_longitude + " TEXT, "
                    + temp_pro_battery_status + " TEXT,"
                    + temp_pro_gps_status + " TEXT, "
                    + temp_pro_uid + " TEXT,"
                    + temp_pro_category_name + " TEXT,"
                    + temp_pro_category_id + " TEXT,"
                    + temp_pro_discount + " TEXT,"
                    + temp_pro_finalamount + " TEXT,"
                    + temp_pro_classification_value + " TEXT,"
                    + temp_pro_mcc_mnc_lac + " TEXT,"
                    + temp_pro_current_date + " TEXT,"
                    + temp_pro_grpId_childId + " TEXT,"
                    + temp_pro_current_time + " TEXT,"
                    + temp_pro_imagename + " TEXT,"
                    + temp_pro_booked_order_type + " TEXT,"
                    + temp_pro_images_status + " TEXT default 0, "
                    + temp_pro_stock_value + " TEXT,"
                    + temp_pro_geo_address + " TEXT,"
                    + temp_pro_user_id + " TEXT,"
                    + temp_pro_orderstatus
                    + " TEXT default false,delete_status Integer default 0)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + RETAILER_SCHEME_ENROLL
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, retailer_id TEXT, status TEXT, date TEXT, time TEXT,gps_status Text,battery_status Text, orderId Text,delete_status Integer DEFAULT 0)");


            objSQLiteDB.execSQL("CREATE TABLE " + SYNC_RetailerStock + " ("
                    + reta_pro_id + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + reta_pro_image + " TEXT,"
                    + reta_pro_current_date2 + " TEXT,"
                    + reta_pro_schemeqty + " TEXT, "
                    + reta_pro_remarks + " TEXT,"
                    + reta_pro_dealerid + " TEXT,"
                    + reta_pro_beatid + " TEXT,"
                    + reta_pro_battery_status + " TEXT,"
                    + reta_pro_gps_status + " TEXT,"

                    + reta_pro_retailerid + " TEXT,"
                    + reta_pro_retailer_name + " TEXT,"
                    + reta_pro_qty + " TEXT, "
                    + reta_pro_scheme + " TEXT,"
                    + reta_pro_total_value + " TEXT, "
                    + reta_pro_rate + " TEXT, "
                    + reta_pro_group_id + " TEXT, "
                    + reta_pro_child_id + " TEXT, "
                    + reta_pro_child_name + " TEXT,"
                    + reta_pro_order_id + " TEXT,"
                    + reta_pro_stock_month + " TEXT,"
                    + reta_pro_category_value + " TEXT,"
                    + reta_pro_latitude + " TEXT,"
                    + reta_pro_longitude + " TEXT, "
                    + reta_pro_uid + " TEXT,"
                    + reta_pro_classification_value + " TEXT,"
                    + reta_pro_mcc_mnc_lac + " TEXT,"
                    + reta_pro_current_date + " TEXT,"
                    + reta_pro_grpId_childId + " TEXT,"
                    + reta_pro_current_time + " TEXT,"
                    + reta_pro_imagename + " TEXT,"
                    + reta_pro_booked_order_type + " TEXT,"
                    + reta_pro_images_status + " TEXT default 0, "
                    + reta_pro_stock_value + " TEXT,"
                    + reta_pro_orderstatus
                    + " TEXT default false,delete_status Integer default 0)");


            objSQLiteDB
                    .execSQL("create table "
                            + SYNC_GIFT_TABLE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT,gift TEXT,gift_id TEXT,quantity TEXT,Customer Text,orderId Text,delete_status Integer DEFAULT 0 )");
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_CALLWISE_IMAGE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, c_code Text,c_img Text,l_id Text,time Text,imei Text,date Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_CREATE_RETAILER_TABLE
                            + " (retailer_id INTEGER PRIMARY KEY, d_code Text,"
                            + " l_code Text,c_name Text,contact_name Text,c_mob Text,create_date Text,create_time Text,imei Text,pin Text,"
                            + " e_mail Text,battery_status Text,gps_status Text,outlettype text,tin Text,lat text,longi text,imagename text, mcc_mnc_lac_cellId Text,seq_no Text,"
                            + " adres_str Text,customer_type Text,geo_add Text, delete_status Integer default 0, comValue Integer default 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_RETAILER_IMAGE_TABLE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, retailer_id Text,c_img Text,l_id Text,time Text,imei Text,date Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_RETAILER_BRAND
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, cname Text, gls Text,ti text,cfl Text,clum Text,led Text,mobid Integer REFERENCES customer_store_table(mobid),delete_status Integer default 0 )");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_DAILYEXPENCE_IMAGE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, image Text , time Text, imei Text, date Text, orderid Text, image2 Text, image3 Text, delete_status Integer default 0) ");

            objSQLiteDB.execSQL("CREATE TABLE " + planned_report_table + " ("
                    + planned_report_table_id
                    + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + planned_report_dealer_id + " Text, "
                    + planned_report_table_date + " Text, "
                    + planned_report_table_dealer + " Text, "
                    + planned_report_table_location + "  Text,"
                    + planned_report_table_totalsale + " Text , "
                    + planned_report_table_tmode + " Text , "
                    + planned_report_table_tto + " Text , "
                    + planned_report_table_tfrom + " Text , "
                    + planned_report_table_status + " Text , "
                    + planned_report_table_totaldistance + " Text , "
                    + planned_report_table_totalcalls + " Text)");

            objSQLiteDB.execSQL("CREATE TABLE " + actual_report_table + " ("
                    + actual_report_table_id
                    + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + actual_report_dealer_id + " Text, "
                    + actual_report_table_date + " Text, "
                    + actual_report_table_dealer + " Text, "
                    + actual_report_table_location + "  Text, "
                    + actual_report_table_totalcalls + "  Text,"
                    + actual_report_table_tfrom + "  Text,"
                    + actual_report_table_tto + "  Text,"
                    + actual_report_table_tmode + "  Text,"
                    + actual_report_table_totaldistance + "  Text,"
                    + actual_report_table_status + "  Text,"
                    + actual_report_table_totalsale + " Text)");

            objSQLiteDB.execSQL("CREATE VIEW Planned_REPORT" + " AS SELECT "
                    + planned_report_table + "." + planned_report_table_id
                    + " AS _id," + " " + planned_report_table + "."
                    + planned_report_dealer_id + "," + " "
                    + planned_report_table + "." + planned_report_table_date
                    + "," + " " + planned_report_table + "."
                    + planned_report_table_dealer + "," + " "
                    + planned_report_table + "."
                    + planned_report_table_location + "," + " "
                    + planned_report_table + "."
                    + planned_report_table_totalcalls + "," + " "
                    + planned_report_table + "."
                    + planned_report_table_totalsale + "" + " FROM "
                    + planned_report_table);

            objSQLiteDB.execSQL(createSYNC_MERGE_RETAILER_ID);


            objSQLiteDB.execSQL("CREATE VIEW Actual_REPORT" + " AS SELECT "
                    + actual_report_table + "." + actual_report_table_id
                    + " AS _id," + " " + actual_report_table + "."
                    + actual_report_dealer_id + "," + " " + actual_report_table
                    + "." + actual_report_table_date + "," + " "
                    + actual_report_table + "." + actual_report_table_dealer
                    + "," + " " + actual_report_table + "."
                    + actual_report_table_location + "," + " "
                    + actual_report_table + "."
                    + actual_report_table_totalcalls + "," + " "
                    + actual_report_table + "." + actual_report_table_totalsale
                    + "" + " FROM " + actual_report_table);

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_NOTIFICATION
                            + "(id INTEGER PRIMARY KEY  ,date Text,fileUrl text,image_type Text,image_path Text,msg text,time Text,title Text,flag Integer default 0, delete_status Integer default 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_Complaint_Redressel
                            + "(id INTEGER PRIMARY KEY  ,date Text,msg text,role_type Text,role_type_name Text, delete_status Integer default 0)");


            objSQLiteDB.execSQL("CREATE TABLE " + report_userTable + " ("
                    + report_userTable_id + "  INTEGER PRIMARY KEY, "
                    + report_date + " Text, "
                    + report_userid + " Text , " + report_username + " Text, "
                    + report_totalcalls + " Text, " + report_totalprodcalls
                    + " Text, " + report_totalsalevalue + " Text, "
                    + report_user_beat_name + " Text)");

            objSQLiteDB.execSQL("CREATE VIEW Report_USER" + " AS SELECT "
                    + report_userTable + "." + report_userTable_id + " AS _id,"
                    + " " + report_userTable + "." + report_userid + "," + " "
                    + report_userTable + "." + report_username + "," + " "
                    + report_userTable + "." + report_totalcalls + "," + " "
                    + report_userTable + "." + report_totalprodcalls + ","
                    + " " + report_userTable + "." + report_totalsalevalue
                    + "," + " " + report_userTable + "."
                    + report_user_beat_name + "" + " FROM " + report_userTable);

            objSQLiteDB.execSQL("CREATE TABLE " + report_sku_userTable + " ("
                    + report_sku_userid + " INTEGET PRIMARY KEY, "
                    + report_sku_productname + " Text, " + report_sku_quantity
                    + " Text, " + report_sku_rate + "  Text, "
                    + report_sku_totalsalerate + " Text)");
            objSQLiteDB.execSQL("CREATE VIEW Report_SKU_USER" + " AS SELECT "
                    + report_sku_userTable + ". " + report_sku_userid
                    + " AS _id," + " " + report_sku_userTable + "."
                    + report_sku_productname + "," + " " + report_sku_userTable
                    + "." + report_sku_quantity + "," + " "
                    + report_sku_userTable + "." + report_sku_rate + "," + " "
                    + report_sku_userTable + "." + report_sku_totalsalerate
                    + "" + " FROM " + report_sku_userTable);

            objSQLiteDB.execSQL(EssQuestionTypeTable);
            objSQLiteDB.execSQL(EssQuestionOptionTable);
            objSQLiteDB.execSQL(EssQuestionGettingTable);
            objSQLiteDB.execSQL(EssAllDataTable);
            objSQLiteDB.execSQL(Target_Report_Show_Table);

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + REPORT_RETAILER
                            + " (cat_id INTEGER PRIMARY KEY , catname_retailerwise Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_TRACKING_DETAILS
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, track_date Text,track_time Text,lat numeric,lng numeric,imei Text,mcc_mnc_lac_cellId Text,location Text,delete_status Integer default 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + Primary_Sale
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + "primary_current_date Text, primary_current_time Text,primary_dealer_name Text, primary_dealer_id Text, "
                            + "primary_product_name Text, primary_cases Text, primary_pieces Text, primary_pro_case_value Text, "
                            + primary_total_value
                            + " Text, "
                            + "primary_catagory_id Text,battery_status Text,gps_status Text, primary_catagory_name Text, primary_product_code Text, primary_order_id Text, "
                            + "primary_grpId_childId Text,primary_mcc_mnc_cell_lacId Text,primary_rate Text,primary_scann Text, primary_order_status Text default false, value_str Text, case_rate Text, pcs_rate Text, delete_status Integer default 0, schemeQty TEXT, lat Text, lng Text, address Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + RETAILER_BALANCE_STOCK
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + "retailer_current_date Text, retailer_current_time Text, retailer_dealer_id Text, "
                            + "retailer_product_name Text, retailer_cases Text, retailer_pieces Text, retailer_pro_case_value Text, "
                            + retailer_total_value
                            + " Text, "
                            + "retailer_catagory_id Text, retailer_catagory_name Text, retailer_product_code Text, retailer_order_id Text, "
                            + "retailer_grpId_childId Text,retailer_rate Text, retailer_order_status Text default false, delete_status Integer default 0, schemeQty TEXT)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_EXPENSE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + " t_mode Text,str_jrny Text,end_jrny Text,total_calls Text,ta_exp Text,"
                            + " da_exp Text,misc_exp Text,total_exp Text,daily_report_date Text,time Text,"
                            + "imei Text,orderid Text,other_postage Text,other_telecom Text,"
                            + " delete_status Integer default 0,image Text, image2 Text, image3 Text,lat Text,longitude Text,address Text,mcc_mnc_lac_cellId Text ,hotelrent Text,b_code Text,remarks Text,date TEXT)");

            // ////// balance Stock Table /////////////////
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + Balance_Stock
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + "imei Text, balance_current_date Text, balance_current_time Text, balance_dealer_id Text, balance_dealer_name Text, "
                            + "balance_product_name Text, balance_manuf_date Text, balance_cases Text,balance_mrp Text, balance_pieces Text, "
                            + "balance_total_value Text, balance_catagory_id Text, balance_catagory_name Text, balance_product_code_ Text, "
                            + "balance_order_id Text, balance_grpID_childId Text,battery_status Text,gps_status Text, lat Text, lng Text, mcc_mnc_lac_cellId Text, basePrice Text, "
                            + "address Text, balance_remove_unique_id Text default false, value_str Text, balance_pcs_mrp Text, balance_order_status Text default false, delete_status Integer default 0)");

            // //////// Login Compititior ////////////

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_COMPETITIOR
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + "compititor_id Text, compititor_name Text, delete_status Integer default 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + Compittior_Table
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + "company_id Text, retailer_id Text, dealer_id Text, sale_value Text, delete_status Integer default 0)");
            // ////////// Damage Replace Report ////////////////
            objSQLiteDB.execSQL("CREATE TABLE " + DamageReport_retailer
                    + " ( id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + damagereplaceretailer_id + " Text, "
                    + damagereplaceretailer_name + " Text)");

            objSQLiteDB.execSQL("CREATE TABLE " + DamageReport_damage
                    + " (id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + DamageReport_pid + " Text, " + DamageReport_name
                    + " Text, " + DamageReport_qty + " Text, "
                    + DamageReport_value + "  Text, " + DamageReport_mrp
                    + "  Text," + DamageReport_retailerid + " Text)");

            objSQLiteDB.execSQL("CREATE TABLE " + ReplaceReport_replace
                    + " (id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + ReplaceReport_pid + " Text, " + ReplaceReport_name
                    + " Text, " + ReplaceReport_qty + " Text, "
                    + ReplaceReport_value + "  Text, " + ReplaceReport_mrp
                    + "  Text," + ReplaceReport_retailerid + " Text)");
            objSQLiteDB.execSQL(createdeleteStatusTable);
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + GEO_FANCING_TABLE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT ,dealer_and_retailer_id Text,latitude Text,longitude Text,role Text,name Text)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + GEOFANCING_TIME_DATAILS_TABLE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT ,dealer_and_retailer_id Text,enter_time Text,exit_time Text,role Text,current_date Text,status Integer,delete_status Integer default 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + SYNC_CallWiseReason
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, dealer_id Text , location_id Text , retailer_id Text , reason Text ,battery_status Text,gps_status Text, call_reason_orderid Text , date Text , time Text , delete_status Integer default 0)");

            // //////// Login WORKING_WITH_STATUS ////////////
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_WORKING_WITH_STATUS
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + " working_id Text, working_name Text, delete_status Integer default 0)");

            // ////// Damage Product Table /////////////////
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + Damage_Product
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + "imei Text, damage_current_date Text, damage_current_time Text, damage_dealer_id Text, "
                            + "damage_product_name Text,battery_status Text,gps_status Text, damage_product_quantity Text, damage_product_mrp Text, damage_product_sale_value Text, "
                            + "damage_catagory_id Text, damage_catagory_name Text, damage_product_code Text, damage_order_id Text, "
                            + "damage_grpID_childId Text,reason_type_id Text,image Text,damage_retailer Text,damage_retailername Text, damage_order_status Text default false,images_status Integer default 0, damage_order_type Integer, delete_status Integer default 0)");

            objSQLiteDB.execSQL("CREATE TABLE " + dealer_ss_table + " ("
                    + dealer_ss_table_id
                    + "  INTEGER PRIMARY KEY AUTOINCREMENT, " + ss_id
                    + " Text , " + ss_name + " Text)");

            objSQLiteDB.execSQL("CREATE TABLE " + NOTIFICATION + "(id INTEGER PRIMARY KEY  ,date Text,msg text, delete_status Integer default 0)");


            // Create Retailer Comment table
            objSQLiteDB.execSQL("CREATE TABLE " + comment_data + " ("
                    + comm_id + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + comm_ord_id + " TEXT ,"
                    + comm_date + " TEXT,"
                    + comm_time + " TEXT,"
                    + comm_user_id + " TEXT, "
                    + comm_loc_id + " TEXT, "
                    + comm_dealer_id + " TEXT,"
                    + comm_retailer_id + " TEXT, "
                    + comm_retailer_name + " TEXT,"
                    + comm_latitude + " TEXT,"
                    + comm_longitude + " TEXT,"
                    + comm_mcc_mnc_lac + " TEXT,"
                    + comm_rmk + " TEXT,"
                    + comm_address + " TEXT,"
                    + comm_battery_status + " TEXT,"
                    + comm_gps_status + " TEXT,"
                    + comm_in_time_stamp + " TEXT,"
                    + comm_out_time_stamp + " TEXT,"
                    + comm_timestamp + " TEXT,"
                    + " delete_status Integer default 0)");


            // Create Competitive Price Intelligence table
            objSQLiteDB.execSQL("CREATE TABLE " + COMPETITIVE_PRICE_INTELLIGENCE + " ("
                    + cpi_id + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + cpi_brand + " TEXT ,"
                    + cpi_weigth + " TEXT,"
                    + cpi_mrp + " TEXT,"
                    + cpi_being_sold_to_consumer + " TEXT, "
                    + cpi_before_trade_scheme + " TEXT, "
                    + cpi_trade_scheme + " TEXT,"
                    + cpi_after_trade_scheme + " TEXT, "
                    + cpi_units_per_case_bag + " TEXT,"
                    + cpi_net_cost_price_to_retailer + " TEXT,"
                    + cpi_retailer_margin_per_unit + " TEXT,"
                    + cpi_consumer_scheme + " TEXT,"
                    + cpi_must_enclose_cash_memo_no + " TEXT,"
                    + cpi_must_enclose_cash_memo_date + " TEXT,"
                    + cpi_latitude + " TEXT,"
                    + cpi_longitude + " TEXT,"
                    + cpi_location + " TEXT,"
                    + cpi_mcc_mnc + " TEXT,"
                    + cpi_order_id + " TEXT,"
                    + cpi_user_id + " TEXT,"
                    + cpi_cur_date + " TEXT,"
                    + cpi_cur_time + " TEXT,"
                    + " delete_status Integer default 0)");


            // Create Feedback Suggestion table
            objSQLiteDB.execSQL("CREATE TABLE " + FEEDBACK_SUGGESTION + " ("
                    + fs_id + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + fs_suggestion + " TEXT ,"
                    + fs_suggested_start_date + " TEXT,"
                    + fs_estimated_volume_growth + " TEXT,"
                    + fs_latitude + " TEXT,"
                    + fs_longitude + " TEXT,"
                    + fs_location + " TEXT,"
                    + fs_mcc_mnc + " TEXT,"
                    + fs_order_id + " TEXT,"
                    + fs_user_id + " TEXT,"
                    + fs_cur_date + " TEXT,"
                    + fs_cur_time + " TEXT,"
                    + " delete_status Integer default 0)");


            // Create Pending Claim table
            objSQLiteDB.execSQL("CREATE TABLE " + PENDING_CLAIM + " ("
                    + pc_id + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + pc_submission_date + " TEXT ,"
                    + pc_distributor_id + " TEXT,"
                    + pc_town_id + " TEXT,"
                    + pc_nature_of_claim + " TEXT, "
                    + pc_invoice_number + " TEXT, "
                    + pc_invoice_date + " TEXT,"
                    + pc_claim_paper + " TEXT, "
                    + pc_remark + " TEXT,"
                    + pc_expected_resolution_date + " TEXT,"
                    + pc_latitude + " TEXT,"
                    + pc_longitude + " TEXT,"
                    + pc_location + " TEXT,"
                    + pc_mcc_mnc + " TEXT,"
                    + pc_battery_status + " TEXT,"
                    + pc_gps_status + " TEXT,"
                    + pc_order_id + " TEXT,"
                    + pc_user_id + " TEXT,"
                    + pc_cur_date + " TEXT,"
                    + pc_cur_time + " TEXT,"
                    + " delete_status Integer default 0)");


            // Create Retailer Images table
            objSQLiteDB.execSQL("CREATE TABLE " + retailer_images + " ("
                    + retailer_auto_inc_id + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + retailer_ord_id + " TEXT ,"
                    + retailer_date + " TEXT,"
                    + retailer_time + " TEXT,"
                    + retailer_user_id + " TEXT, "
                    + retailer_loc_id + " TEXT, "
                    + retailer_dealer_id + " TEXT,"
                    + retailer_id + " TEXT,"
                    + retailer_name + " TEXT,"
                    + retailer_latitude + " TEXT,"
                    + retailer_longitude + " TEXT,"
                    + retailer_mcc_mnc_lac + " TEXT,"
                    + retailer_rmk + " TEXT,"
                    + retailer_address + " TEXT,"
                    + retailer_in_time_stamp + " TEXT,"
                    + retailer_out_time_stamp + " TEXT,"
                    + retailer_timestamp + " TEXT,"
                    + retailer_image + " TEXT,"
                    + retailer_image2 + " TEXT,"
                    + retailer_image3 + " TEXT,"
                    + " images_status Integer default 0)");


            // Complaint Report table create:-

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + ComplaintReport
                            + "(id INTEGER PRIMARY KEY ,complaintProduct TEXT  ,size Text ," +
                            "natureOfComplaintMentioned Text,quantityLying Text,complaintWithRetailer Text,casesWithComplaint Text," +
                            "casesRv Text,packersSlip Text," +
                            "billNo Text ,date Text ,amountOfBill Text ,productDispatched Text ,manufacturingUnit Text," +
                            "sampleClosed Text, concernedSuperDistributorAddress Text, concernedRetailerAddress Text," +
                            "concernedConsumerAddress Text , actionTaken Text ,comments Text , curr_date Text ," +
                            "curr_time Text , latitude Text , longitude Text , geo_address Text , mcc_mnc Text , " +
                            "unique_id Text , order_id Text , user_id TEXT , complaintID Text , " +
                            "agreeID Text ,gps_status Text,battery_status Text, agreeStr Text , complaintByStr Text , delete_status INTEGER DEFAULT 0 )");

            //Travelling Expense Bill Table Create:-
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + TravellingExpenseBill
                            + "(id INTEGER PRIMARY KEY ,travellingDate TEXT  ,arrivalTime Text ," +
                            "departureTime Text,distance Text,fare Text,da Text," +
                            "hotel Text,postage Text," +
                            "telephoneExpense Text ,conveyance Text ,misc Text ,total Text ,arrivalID Text," +
                            "departureID Text, travelModeID Text, latitude Text , longitude Text , geo_address Text , " +
                            "mcc_mnc Text ,Oneimage Text,twoimage Text,threeimage Text, curr_date Text, curr_time Text," +
                            "unique_id Text ,gps_status Text,battery_status Text, order_id Text , user_id TEXT , delete_status INTEGER DEFAULT 0,images_status INTEGER DEFAULT 0 )");

            //Product Investigation Report Table Create:-
            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + ProductInvestigationReport
                            + "(id INTEGER PRIMARY KEY ,brandProduct TEXT  ,packSize Text ," +
                            "productPurchasedFrom Text,productPurchasedTown Text,productPurchasedDistrict Text," +
                            "productPurchasedState Text,productPurchasedPhone Text," +
                            "productPurchasedFax Text ,productPurchasedEmail Text ,otherEstimatedSales Text ," +
                            "manufactureDetail Text ,manufactureTown Text, manufactureDistrict Text," +
                            "manufactureState Text, manufactureGodownPhone Text, manufactureGodownMobile Text ," +
                            "manufactureGodownFax Text , manufactureGodownEmail Text , manufactureOfficePhone Text ," +
                            "manufactureOfficeMobile Text , manufactureOfficeFax Text, manufactureOfficeEmail Text ," +
                            "manufactureGodownResidencePhone Text , manufactureGodownResidenceMobile Text , " +
                            "manufactureGodownResidenceFax TEXT , manufactureGodownResidenceEmail Text ," +
                            "detailsStockiest Text , stockiestTown Text , StockiestDistrict Text ," +
                            "stockiestState Text ,stockiestGodownPhone Text, stockiestGodownMobile Text," +
                            "stockiestGodownFax Text , stockiestGodownEmail Text ,stockiestOfficePhone Text ," +
                            "stockiestOfficeMobile Text , stockiestOfficeFax Text , stockiestOfficeEmail Text , " +
                            "stockiestResidencePhone Text , stockiestResidenceMobile Text , stockiestResidenceFax Text ," +
                            "stockiestResidenceEmail Text , estimatedMonthlyTurnOver Text , anyOtherComment text ," +
                            "latitude Text , longitude Text , geo_address Text , curr_date Text , curr_time Text ," +
                            "mcc_mnc Text , order_id Text ,gps_status Text,battery_status Text, unique_id Text , user_id Text , delete_status INTEGER DEFAULT 0 )");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + MEETING_TABLE
                            + " (id INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + " meet_id Text,meet_name Text,meet_address Text,type_meet Text,type_with Text,time_in Text,time_out Text,meet_remark Text,contact_no Text,followup_date Text,followup_time TEXT,"
                            + " submit_date Text,lat Text,lng Text,geoaddress Text,battery_status Text,gps_status Text,mcc_mnc_cellId Text,submit_date1 Text,order_id Text,delete_status Integer default 0)");


            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_TYPE_MEETING
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, meet_id Text, meet_name Text, delete_status Integer default 0)");

            objSQLiteDB
                    .execSQL("CREATE TABLE "
                            + LOGIN_MEETING_WITH_TYPE
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT, meet_with_Id Text, meet_with_name Text, delete_status Integer default 0)");

        }


        @Override
        public void onUpgrade(SQLiteDatabase objSqLiteDB, int oldVersion,
                              int newVersion) {

            if (newVersion == 11) {
                objSqLiteDB.execSQL("ALTER TABLE Primary_Sale ADD COLUMN primary_mcc_mnc_cell_lacId Text ");
                objSqLiteDB.execSQL("ALTER TABLE Distributor_Counter_Sale ADD COLUMN counter_sale_mcc_mnc_cell_lacId Text ");
                objSqLiteDB
                        .execSQL("CREATE TABLE "
                                + LOGIN_OTHER_APP_MODULE
                                + "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "other_module_icon_image Text ," +
                                "other_module_id Text," +
                                "other_module_name Text)");

                objSqLiteDB
                        .execSQL("CREATE TABLE "
                                + MEETING_TABLE
                                + " (id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                + " meet_id Text,meet_name Text,meet_address Text,type_meet Text,type_with Text,time_in Text,time_out Text,meet_remark Text,contact_no Text,followup_date Text,followup_time TEXT,"
                                + " submit_date Text,lat Text,lng Text,geoaddress Text,battery_status Text,gps_status Text,mcc_mnc_cellId Text,submit_date1 Text,order_id Text,delete_status Integer default 0)");


                objSqLiteDB
                        .execSQL("CREATE TABLE "
                                + LOGIN_TYPE_MEETING
                                + "(id INTEGER PRIMARY KEY AUTOINCREMENT, meet_id Text, meet_name Text, delete_status Integer default 0)");
                objSqLiteDB
                        .execSQL("CREATE TABLE "
                                + LOGIN_MEETING_WITH_TYPE
                                + "(id INTEGER PRIMARY KEY AUTOINCREMENT, meet_with_Id Text, meet_with_name Text, delete_status Integer default 0)");

            }

        }
    }

    // LOGIN////////////////////////////////////////////////////////////////////////////////////////////////////////


    public Cursor check_Complaint2() {
        Cursor cursor;
        String quString = "select * from comment_new_table where delete_status=0";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public Cursor getImgCountComplaint2() {
        String p_query = "select * from comment_new_table where images_status = 0 ";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);
        return cursor;
    }

    public Cursor check_AddCloseoftheday() {

        Cursor cursor;
        String quString = "select * from " + TABLE_CLOSE_THE_DAY + " where delete_status=0";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }


    public Cursor check_marketreport1() {
        Cursor cursor;
        String quString = "select * from " + TABLE_REPORT1
                + " where delete_status=0";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;

    }

    public Cursor check_marketreport2() {
        Cursor cursor;
        String quString = "select * from " + TABLE_REPORT2
                + " where delete_status=0";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;

    }

    public Cursor getTradeMeetingsImages(String tableName) {

        String p_query = "select * from " + tableName + " where image_status=0 ";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;

    }

    public Cursor getImgCountMarket2() {

        String p_query = "select * from marketreport_two_table where images_status=0 ";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;

    }

    public Cursor getImgCountMarket1() {

        String p_query = "select * from marketreport_one_table where images_status=0 ";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;

    }


    public Cursor check_user_pass() {
        Cursor cursor;
        String quString = "select * from UserName_Return";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public Cursor check_AppDeliveryDate() {
        Cursor cursor;
        String quString = "select * from Appdelivery";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }


    public Cursor check_ph_status() {
        Cursor cur;
        String str = "Select * from " + phone_status + " Where delete_status=0";
        cur = objSqliteDB.rawQuery(str, null);
        return cur;
    }

    public Cursor getRetailerLatlong1(String retailerId) {
        Cursor cursor = null;
        try {
            String quString = "select * from retailer_data_insert where c_code='" + retailerId + "'";
            /*"' order by l_name" ;*/
            cursor = objSqliteDB.rawQuery(quString, new String[]{});
        } catch (Exception e) {
            System.out.println(e);
        }

        return cursor;
    }

    public Cursor getUserStatusCount() {

        String p_query = "select * from " + LOGIN_USERDETAIL;
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }

    public Cursor getTrackDistance() {

        String p_query = "select * from " + NOTIFICATION + " where delete_status=0";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }

    public Cursor getTrackNotification() {

        String p_query = "select * from " + NOTIFICATION + "";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }

    public Cursor getTotalFulFillment_table1() {
        String p_query = "select * from " + TotalFulFillment_TABLE1 + "";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }

    public Cursor checkUserPassStatus() {

        Cursor cursor;
        String quString = "select * from " + LOGIN_USERDETAIL;
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public Cursor getFlightModeOnStatus12() {
        Cursor cursor;
        String quString = "select FlightModeOnOffOrderId,FlightModeOnOffId,FlightModeOnOffStatus from FlightModeOnOffTable1 "
                + "where FlightModeOnOffStatus = 0";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;

    }

    public Cursor getTradeMeetingData(String tableName) {
        Cursor cursor;
        String quString = "select * from " + tableName + " where delete_status=0";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public Cursor check_status_date() {
        Cursor cursor;
        String quString = "select * from LOGIN_check_status";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public Cursor getFlightModeOnStatus() {
        Cursor cursor;
        String quString = "select FlightModeOnOffOrderId,FlightModeOnOffId from FlightModeOnOffTable1 "
                + "where FlightModeOnOffStatus= 0";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;

    }

    public Cursor getDisrtributorDetailInCounterSale() {
        Cursor cur = objSqliteDB.rawQuery("SELECT id as _id, DealerName from "
                + LOGIN_DEALER_TABLE + " order by DealerName ", new String[]{});
        return cur;
    }


    //Setting Total Sale Value on TextView in Retailer Profile:-
    public Cursor getTotalValue(String order_id) {

        String p_query = "select SUM(temp_pro_total_value) as total_sum , COUNT(DISTINCT temp_pro_child_id) AS total_SKU from tempdatastore where temp_pro_order_id='" + order_id + "'";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }


    //Setting Total Sale Value on TextView in Retailer Profile:-
    public String getOrderID(String temp_pro_retailerid) {
        String order_id = "";
        String p_query = "select temp_pro_order_id  from tempdatastore where temp_pro_retailerid= '" + temp_pro_retailerid + "'";
        Cursor cursor1 = objSqliteDB.rawQuery(p_query, null);

        if (cursor1 != null) {
            if (cursor1.moveToFirst()) {
                do {
                    order_id = cursor1.getString(cursor1.getColumnIndex("temp_pro_order_id"));
                } while (cursor1.moveToNext());
            }
        }
        return order_id;
    }


    public Cursor getImgCountCallWiseReporting() {

        String p_query = "select * from CallwiseReportingImgTable where image=0";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;

    }

    public Cursor getImgCountCallWiseReporting111() {

        String p_query = "select * from tempdatastore where image_status='0'";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;

    }


    public Cursor getShareCount(String date) {

        String p_query = "select * from shareinformationcount where date= '" + date + "'";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);
        int count = cursor.getCount();
        return cursor;

    }

    public Cursor getAllbtnStatus() {
        Cursor cursor;
        String quString = "select callwisereporting ,salessummry from "
                + LOGIN_CONSTANT_DELETE;
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public Cursor updateUserInformation() {
        return objSqliteDB.rawQuery("SELECT userId, email, mobile FROM " + LOGIN_CONSTANT_DELETE, null);
    }

    public Cursor getUpdatedLeaveValue() {
        return objSqliteDB.rawQuery("SELECT leave_id, leave_value FROM " + LEAVE_TYPE, null);
    }

    public void updateLeaveValueStatus(String leaveID) {
        Cursor mCursor = objSqliteDB.rawQuery("UPDATE " + LEAVE_TYPE + " SET leave_value = leave_value-1 WHERE leave_id=" + leaveID, null);
        int count = mCursor.getCount();
    }


    public int deleteAllcheck_status() {
        return objSqliteDB.delete(LOGIN_check_status, null, null);
    }

    public int deleteAllClosetheday() {
        return objSqliteDB.delete(TABLE_CLOSE_THE_DAY, null, null);
    }


    public String getStatusDate() {
        String date;
        Cursor cursor;
        String qry = "select attn_status  from" + LOGIN_check_status;
        cursor = objSqliteDB.rawQuery(qry, null);
        cursor.moveToFirst();
        date = cursor.getString(cursor.getColumnIndex("attn_status"));
        return date;

    }

    public long user_pass(String user, String pass, String imei) {
        this.user_pass.bindString(1, user);
        this.user_pass.bindString(2, pass);
        this.user_pass.bindString(3, imei);
        return this.user_pass.executeInsert();

    }

    /* public long user_insert_from_url(String user, String pass, String imei,
                                      String userid) {
         this.user_pass.bindString(1, user);
         this.user_pass.bindString(2, pass);
         this.user_pass.bindString(3, imei);
         this.user_pass.bindString(4, userid);
         return this.user_pass.executeInsert();

     }
 */
    public int deleteAllCustomer() {
        return objSqliteDB.delete(LOGIN_RETAILER_TABLE, null, null);
    }

    public int deleteAllPaymentMode() {
        return objSqliteDB.delete(LOGIN_PAYMENT_MODE, null, null);
    }

    public int deleteAllRetailerWithBeat() {
        return objSqliteDB.delete(LOGIN_RETAILER_TARGET_BEAT, null, null);
    }

    public int deleteAllCLassification() {
        return objSqliteDB.delete(LOGIN_Classification_TABLE, null, null);
    }

    public int deleteAllState() {
        return objSqliteDB.delete(LOGIN_STATE, null, null);
    }

    public int deleteAllRecommendedSKU() {
        return objSqliteDB.delete(RecommendedSKU, null, null);
    }

    public int deleteAllTownNameList() {
        return objSqliteDB.delete(TownNameList, null, null);
    }


    public int deleteAllJuniorUSer() {
        return objSqliteDB.delete(LOGIN_JUNIORUSER_TABLE, null, null);
    }

    public int deleteAllStock() {
        return objSqliteDB.delete(LOGIN_PRODUCT_Stock, null, null);
    }

    public int deleteAllGift() {
        return objSqliteDB.delete(LOGIN_Gift, null, null);
    }

    public int deleteAllOutlets() {
        return objSqliteDB.delete(LOGIN_OUTLETS, null, null);
    }

    public int deleteAllOutlet_Category() {
        return objSqliteDB.delete(OutletCategoryTable, null, null);
    }

    public int deleteAllOutlet() {
        return objSqliteDB.delete(OutletTypeTable, null, null);
    }

    public int deleteAllIsrUser() {
        return objSqliteDB.delete(LOGIN_ISRUSER_TABLE, null, null);
    }


    public int deleteAllLocation() {
        return objSqliteDB.delete(LOGIN_LOCATION_TABLE, null, null);
    }

    public int deleteAllProduct() {
        return objSqliteDB.delete(LOGIN_PRODUCT_TABLE, null, null);
    }


    public int deleteAllRetailerTarget() {
        return objSqliteDB.delete(LOGIN_RETAILER_TARGET_BEAT, null, null);
    }

    public int deleteAllProduct1() {
        return objSqliteDB.delete(Product_TABLE, null, null);
    }

    public int deleteAllBeat() {
        return objSqliteDB.delete(LOGIN_BEAT_TABLE, null, null);
    }

    public int deleteAllIsr() {
        return objSqliteDB.delete(LOGIN_ISR_TABLE, null, null);
    }

    public int deleteAllMTP() {
        return objSqliteDB.delete(LOGIN_MTP_DATA, null, null);
    }

    public int deleteAllTaskoftheday() {
        return objSqliteDB.delete(LOGIN_TASK_OF_THE_DAY, null, null);
    }

    public int deleteAllOwnerShip() {
        return objSqliteDB.delete(LOGIN_OWNERSHIPTYPE, null, null);
    }

    public int deleteAllMaritalStatus() {
        return objSqliteDB.delete(LOGIN_MARITIAL_STATUS, null, null);
    }

    public void DeleteDealer() {

        objSqliteDB.delete(LOGIN_DEALER_TABLE, null, null);

    }

    public void DeleteAppModule() {

        objSqliteDB.delete(LOGIN_APP_MODULE, null, null);

    }

    public void DeleteOtherAppModule() {

        objSqliteDB.delete(LOGIN_OTHER_APP_MODULE, null, null);

    }

    public void DeleteSubAppModule() {

        objSqliteDB.delete(LOGIN_SUB_APP_MODULE, null, null);

    }


    // Delete method user town
    public void deleteUserTown() {

        objSqliteDB.delete(userTown, null, null);

    }

    // Delete method user town
    public void deleteColleague() {

        objSqliteDB.delete(userColleague, null, null);

    }

    public void DeleteAllData() {

        objSqliteDB.delete(LOGIN_CONSTANT_DELETE, null, null);

    }

    public void DeleterFulfillment() {
        objSqliteDB.delete(TotalFulFillment_TABLE, null, null);
    }

    public void DeleteFullfillmentReportTable() {

        objSqliteDB.delete(FullfillmentReportRetailerTable, null, null);

    }

    public void DeleteFullfillmentProductTable() {

        objSqliteDB.delete(FullfillmentReportProductTable, null, null);

    }


    public int deleteAllComplaintTypes() {
        return objSqliteDB.delete(LOGIN_COMPLAINT_TABLE, null, null);
    }

    public int deleteAllNonProductive() {
        return objSqliteDB.delete(LOGIN_NON_PRODUCTIVE, null, null);
    }

    public int deleteAllReasonType() {
        return objSqliteDB.delete(LOGIN_RETURN_REASON_TYPE, null, null);
    }


    public int deleteAllLEaveTypes() {
        return objSqliteDB.delete(LEAVE_TYPE, null, null);
    }

    public int deleteAllSchemeTypes() {
        return objSqliteDB.delete(SCHEME_TYPE, null, null);
    }

    public int deleteAllFeedback_FromTypes() {
        return objSqliteDB.delete(LOGIN_FEEDBACK_TABLE, null, null);
    }

    public int deleteAllCat() {
        return objSqliteDB.delete(LOGIN_PRODUCT_CATAGORY_TABLE, null, null);
    }

    public int deleteAlldamageCat() {
        return objSqliteDB.delete(LOGIN_DAMAGEPRODUCT_CATAGORY_TABLE, null, null);
    }

    public int deleteAlldamageCatproduct() {
        return objSqliteDB.delete(LOGIN_DAMAGEPRODUCT_TABLE, null, null);
    }

    public int deleteallss() {
        return objSqliteDB.delete(dealer_ss_table, null, null);
    }

    public int deleteAllUrlUser() {
        return objSqliteDB.delete(LOGIN_USERNAME_INSERT, null, null);
    }

    public int deleteAlldealer() {
        return objSqliteDB.delete(LOGIN_DEALER_SALE_TABLE, null, null);
    }


    public int deleteAllMeetingType() {
        return objSqliteDB.delete(LOGIN_TYPE_MEETING, null, null);
    }

    public int deleteAllMeetingWithType() {
        return objSqliteDB.delete(LOGIN_MEETING_WITH_TYPE, null, null);
    }

    public String SelectConstantsTrack() {
        String p_query = "select time from " + LOGIN_CONSTANT_TRACKING;
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);
        String existtime = "0";
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    existtime = cursor.getString(cursor.getColumnIndex("time"));
                } while (cursor.moveToNext());
            }
        }
        return existtime;
    }

    public long travelling_mode_insert(int id, String travelling_modes) {
        this.travelling_mode_statement.bindLong(1, id);
        this.travelling_mode_statement.bindString(2, travelling_modes);

        return this.travelling_mode_statement.executeInsert();

    }

    public void deleteAllTrackingTime() {

        objSqliteDB.delete(LOGIN_TRACKING_STANDERDTIME, null, null);
        objSqliteDB.delete(LOGIN_TRACKINGTIME_MASTER, null, null);
        String qry1 = "delete from sqlite_sequence where name='"
                + LOGIN_TRACKING_STANDERDTIME + "'";
        String qry2 = "delete from sqlite_sequence where name='"
                + LOGIN_TRACKINGTIME_MASTER + "'";
        objSqliteDB.execSQL(qry1);
        objSqliteDB.execSQL(qry2);

    }

    public long track(String t1) {
        this.track_time_insert.bindString(1, t1);
        this.track_time_insert.bindLong(2, 0);
        return this.track_time_insert.executeInsert();

    }

    public String checkStarttime() {
        // Cursor cursor;
        String starttime = "00:00:00";
        String quString = "select t1 from " + LOGIN_TRACKINGTIME_MASTER
                + " where id=1";
        Cursor cursor1 = objSqliteDB.rawQuery(quString, null);
        if (cursor1 != null) {
            if (cursor1.moveToFirst()) {
                do {
                    starttime = cursor1.getString(cursor1.getColumnIndex("t1"));
                } while (cursor1.moveToNext());
            }
        }
        return starttime;
    }

    public String checkEndtime() {
        // Cursor cursor;
        String endtime = "00:00:00";
        String quString = "select t1 from " + LOGIN_TRACKING_STANDERDTIME
                + " where id=2";
        Cursor cursor1 = objSqliteDB.rawQuery(quString, null);
        if (cursor1 != null) {
            if (cursor1.moveToFirst()) {
                do {
                    endtime = cursor1.getString(cursor1.getColumnIndex("t1"));
                } while (cursor1.moveToNext());
            }
        }
        return endtime;
    }

    public Cursor getTrackTimeDelay() {
        // Cursor cursor;
        String quString = "select * from " + LOGIN_TRACKINGTIME_MASTER;
        Cursor cursor1 = objSqliteDB.rawQuery(quString, null);
        return cursor1;
    }

    public long UpdateStatus(int p) {
        ContentValues cv = new ContentValues();
        cv.put("status", 1);
        long a = objSqliteDB.update(LOGIN_TRACKINGTIME_MASTER, cv, "id" + "="
                + p, null);
        return a;
    }


    public long UpdateStatus434() {
        ContentValues cv = new ContentValues();
        cv.put("flag", 1);
        long a = objSqliteDB.update(SYNC_NOTIFICATION, cv, "flag" + "="
                + 0, null);
        return a;
    }

    // /////////////////////////////////////////////////////////////////////////////////////////////////

    // /////////////////////////////////////////ATTENDANCE
    // ACTIVITY//////////////////////////////////////////

    public Cursor getWorkingWithStatus() {
        Cursor cursor = objSqliteDB.rawQuery(
                "SELECT working_id as _id, working_name from "
                        + LOGIN_WORKING_WITH_STATUS, new String[]{});
        return cursor;
    }

    public Cursor getallWorkingStatus() {
        String res1 = "Select * from " + LOGIN_ATTENDANCE_STATUS;
        Cursor re1 = objSqliteDB.rawQuery(res1, null);
        return re1;
    }


    public String getProductName(String id) {
        String temp_pro_child_name12 = "";
        String res1 = "Select * from product_data_insert_sale_table where p_code='" + id + "'";
        Cursor re1 = objSqliteDB.rawQuery(res1, null);
        if (re1 != null) {
            if (re1.getCount() > 0) {
                while (re1.moveToNext()) {
                    temp_pro_child_name12 = re1.getString(re1.getColumnIndex("p_name"));
                }
            }
        }
        return temp_pro_child_name12;
    }
    //	public Cursor getAllAttnStatus() {
    //		Cursor cur = objSqliteDB.rawQuery("SELECT id as _id, " + attn_status
    //				+ " from " + LOGIN_ATTENDANCE_STATUS, new String[] {});
    //		return cur;
    //	}

    public Cursor getAllAttnStatus() {
        Cursor cur = objSqliteDB.rawQuery("SELECT WorkingStatusId1 as _id, " + workingStatusName
                + " from " + WorkngStatus_TABLE, new String[]{});
        return cur;
    }

    public Cursor getAllTAskofTheDay() {
        Cursor cur = objSqliteDB.rawQuery("SELECT  task_id as _id, name "
                + " from " + LOGIN_TASK_OF_THE_DAY, new String[]{});
        return cur;
    }

    public Cursor getAllNonProductive() {
        Cursor cur = objSqliteDB.rawQuery("SELECT  id as _id, name "
                + " from " + LOGIN_NON_PRODUCTIVE, new String[]{});
        return cur;
    }


    public Cursor getAllReasonType() {
        Cursor cur = objSqliteDB.rawQuery("SELECT  id as _id, name "
                + " from " + LOGIN_RETURN_REASON_TYPE, new String[]{});
        return cur;
    }

    public Cursor getAllLeaveStatus() {
        return objSqliteDB.rawQuery("SELECT leave_id as _id, leave_name from "
                + LEAVE_TYPE, new String[]{});
    }


    public Cursor getAllLeaveStatus11234() {
        return objSqliteDB.rawQuery("SELECT  * from " + LEAVE_TYPE, new String[]{});
    }

    public int deleteAllAttandance(String id) {
        return objSqliteDB.delete(ATTENDANCE_STORETABEL, "attn_id" + "=?",
                new String[]{id});
    }


    public String getValue(String table, String column, String wc) {
        String value = "";
        Cursor cur = objSqliteDB.rawQuery("SELECT " + column
                + " from " + table + " where " + wc, new String[]{});
        try {
            if (cur.getCount() > 0) {
                if (cur.moveToFirst()) {
                    value = cur.getString(cur.getColumnIndex(column));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

   /* public long atten_insert(String Attn_id, String work_sta, String remark,
                             String attn_time, String attn_date, String imei,
                             double check_in_lat, double check_in_long,
                             String check_mcc_mnc_lac_cellId, String image, String order_id,
                             String location, String working_With, String daily_newsearch,
                             String daily_workingwith, String remarks, String delete_status,
                             String daily_status, String images_status, String leaveID) {
        this.atten_insert.bindString(1, Attn_id);
        this.atten_insert.bindString(2, work_sta);
        this.atten_insert.bindString(3, remark);
        this.atten_insert.bindString(4, attn_time);
        this.atten_insert.bindString(5, attn_date);
        this.atten_insert.bindString(6, imei);
        this.atten_insert.bindDouble(7, check_in_lat);
        this.atten_insert.bindDouble(8, check_in_long);
        this.atten_insert.bindString(9, check_mcc_mnc_lac_cellId);
        this.atten_insert.bindString(10, image);
        this.atten_insert.bindString(11, order_id);
        this.atten_insert.bindString(12, location);
        this.atten_insert.bindString(13, working_With);
        this.atten_insert.bindString(14, daily_newsearch);
        this.atten_insert.bindString(15, daily_workingwith);
        this.atten_insert.bindString(16, remarks);
        this.atten_insert.bindString(17, delete_status);
        this.atten_insert.bindString(18, daily_status);
        this.atten_insert.bindString(19, images_status);
        this.atten_insert.bindString(20, leaveID);
        return this.atten_insert.executeInsert();

    }*/

    // ////////////////////////////////////////////////////////////////////////////////////////////////////

    // ///GENERIC METHODS OF DATABASE//////////////////////////

    public int Alldelete(String table) {// final
        return objSqliteDB.delete(table, null, null);

    }

    public long InsertData(String tablename, ContentValues cv, String whereclm) {
        long a = objSqliteDB.insert(tablename, whereclm, cv);
        return a;

    }

    public Cursor insertRetailerStockData(String tableName, String order_ID,
                                          String product_ID, String productQty, String productPrice) {
        String mString = "UPDATE retailerbalancestock1 " +
                "SET reta_pro_qty='" + productQty +
                "', reta_pro_total_value='" + productPrice +
                "' WHERE reta_pro_order_id='" + order_ID +
                "' AND reta_pro_child_id='" + product_ID + "'";
        return objSqliteDB.rawQuery(mString, null);
    }

    public Cursor getPersonRole() {
        Cursor res;
        String quString = "Select * from constants_flag";
        res = objSqliteDB.rawQuery(quString, null);
        return res;
    }


    public Cursor getFullfillmentRetailer() {
        Cursor res;
        String quString = "Select * from " + FullfillmentReportRetailerTable;
        res = objSqliteDB.rawQuery(quString, null);
        return res;
    }

    public Cursor getFullfillmentProduct(String retailerid) {
        Cursor res;
        String quString = "Select * from " + FullfillmentReportProductTable + " where FullfillmentReportproductRetailerId = '" + retailerid + "'";
        res = objSqliteDB.rawQuery(quString, null);
        return res;
    }

    public long UpdateData(String tablename, ContentValues cv, String whereclm,
                           String equlvalue) {

        long a = objSqliteDB.update(tablename, cv, whereclm + "=" + equlvalue, null);
        return a;
    }


    public void UpdateColumn(String tablename, String update_value) {
        String str = ("UPDATE " + tablename
                + " SET balance_remove_unique_id = '" + update_value + "' WHERE balance_remove_unique_id = 'false'");
        objSqliteDB.execSQL(str);
    }

    public long UpdateDataStatus(String tablename, ContentValues cv) {

        long a = objSqliteDB.update(tablename, cv, null, null);
        //objSqliteDB.close();
        return a;
    }

    public int UpdateDataStatus1(String unique_id) {

        String que = "Update tempdatastore set delete_status = 1 where temp_pro_uid in (" + unique_id + ")";

        Cursor a = objSqliteDB.rawQuery(que, null);
        //objSqliteDB.close();
        int count = a.getCount();
        return count;
    }


    public int UpdateDataStatusReatailerLatLng(String tablename, String lat, String lng, String retailerid) {

        String str = ("UPDATE  retailer_data_insert SET lat = '" + lat + "', lng ='" + lng + "' WHERE c_code = '" + retailerid + "'");

        Cursor a = objSqliteDB.rawQuery(str, null);
        //objSqliteDB.close();
        int count = a.getCount();
        return count;
    }


    public long UpdateDataStatusReatailerLatLng123(String tablename,
                                                   ContentValues cv, String retailerid) {
        long a = objSqliteDB.update(tablename, cv, " c_code='" + retailerid
                + "'", null);
        return a;
    }

    public Cursor delete_entries(String table, String id, String wherecolumn) {
        Cursor cursor;
        String quString = "delete from " + table + " where " + wherecolumn
                + " in (" + id + ")";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public long damage_delete() {
        return objSqliteDB
                .delete(DataBaseManipulate.Damage_Product, null, null);

    }

    public int deleteAllConstants() {
        objSqliteDB.delete(LOGIN_OUTLETS, null, null);
        objSqliteDB.delete(LOGIN_TRAVELLINGMODE, null, null);
        objSqliteDB.delete(LOGIN_OWNERSHIPTYPE, null, null);
        objSqliteDB.delete(LOGIN_MARKETGIFT, null, null);
        objSqliteDB.delete(LOGIN_ATTENDANCE_STATUS, null, null);
        objSqliteDB.delete(LOGIN_ROLE, null, null);
//        objSqliteDB.delete(LOGIN_DAILY_REPORTING, null, null);
        return objSqliteDB.delete(LOGIN_FIELDEXPERINCE, null, null);

    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////
    /* ALL SYNC METHOD's */

    // For Common Sync Method
    public Cursor sync_common_method(String tablename) {
        String quString = "select * from " + tablename
                + " where delete_status=0";
        return objSqliteDB.rawQuery(quString, null);
    }

    public Cursor sync_dealer_damage(String tablename) {
        String quString = "select * from " + tablename
                + " where damage_order_type=1 and delete_status=0";
        return objSqliteDB.rawQuery(quString, null);
    }


    public Cursor sync_retailer_damage(String tablename) {
        String quString = "select * from " + tablename
                + " where damage_order_type=2 and delete_status=0";
        return objSqliteDB.rawQuery(quString, null);
    }


    // For Daily Sales Report
    public Cursor check_dailyStatus() {
        Cursor cursor;
        String quString = "select * from Daily_Sales_Report where delete_status=0";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    // Reporting Maanger All Data Getting Method:-
    public Cursor reportingManagerFill() {
        Cursor cursor;
        String quString = "select * from reportingManagerTable";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    // For Retailer Stock
    public Cursor checkRetailerStockStatusByGroup() {
        Cursor cursor;

        objSqliteDB = objDataBaseHelper.getReadableDatabase();
        String quString = "select *,sum(reta_pro_qty) as total_prod_qty from retailerbalancestock1 where delete_status=0  ";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public Cursor checkRetailerStockStatus() {
        Cursor cursor;
        objSqliteDB = objDataBaseHelper.getReadableDatabase();

        String quString = "select * from retailerbalancestock1 where delete_status=0 '";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    // For CallWise Reporting
    public Cursor checkCallWiseReportingStatusByGroup() {
        Cursor cursor;

        objSqliteDB = objDataBaseHelper.getReadableDatabase();
        String quString = "select *,sum(temp_pro_qty) as total_prod_qty,sum(temp_pro_total_value) as total_sale_value from tempdatastore where delete_status=0 AND temp_pro_orderstatus !='false' group by temp_pro_order_id";
        //  String quString = "select *,sum(temp_pro_qty) as total_prod_qty,sum(temp_pro_total_value) as total_sale_value from tempdatastore where temp_pro_order_id=  '20171025194812'";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public Cursor checkISrCallWiseReportingStatusByGroup() {
        Cursor cursor;

        objSqliteDB = objDataBaseHelper.getReadableDatabase();
        String quString = "select *,sum(isr_pro_qty) as total_prod_qty,sum(isr_pro_total_value) as total_sale_value from isrtempdatastore where delete_status=0 AND isr_pro_orderstatus !='false' group by isr_pro_order_id";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public Cursor checkCallWiseReportingStatus() {
        Cursor cursor;
        objSqliteDB = objDataBaseHelper.getReadableDatabase();

        String quString = "select * from tempdatastore where delete_status=0 AND booked_order_type ='true'";
        //  String quString = "select * from tempdatastore   where temp_pro_order_id=  '20171025194812'";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public Cursor checkISRCallWiseReportingStatus() {
        Cursor cursor;
        objSqliteDB = objDataBaseHelper.getReadableDatabase();

        String quString = "select * from isrtempdatastore ";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public Cursor getTotalValue(String fromDate, String toDate) {
        Cursor cursor;
        String quString = "SELECT SUM(temp_pro_total_value) as total_value from tempdatastore where temp_pro_current_date BETWEEN '" + fromDate + "' AND '" + toDate + "'";

        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public Cursor getTotalValueFromDate(String date) {
        Cursor cursor;
        String quString = "SELECT SUM(temp_pro_total_value) as total_value from tempdatastore where temp_pro_current_date='" + date + "'";

        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public Cursor getTemp6(String fromDate, String toDate) {
        Cursor cursor;
        String quString = "SELECT temp_pro_current_date,temp_pro_child_id, category_name ,SUM(temp_pro_total_value) as sale_value FROM tempdatastore INNER JOIN product_data_insert_sale_table pdist ON pdist.p_code=tempdatastore.temp_pro_child_id INNER JOIN product_category_table pct ON pct.category_id=pdist.categoryid where temp_pro_current_date  BETWEEN '" + fromDate + "' AND '" + toDate + "'  GROUP BY category_name";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public Cursor getTemp(String fromDate, String toDate) {
        Cursor cursor;
        String quString = "SELECT temp_pro_current_date,SUM(temp_pro_total_value) as sale_value FROM tempdatastore where temp_pro_current_date BETWEEN '" + fromDate + "' AND '" + toDate + "'GROUP BY temp_pro_current_date";
        //String quString = "select p_value from product_data_insert_sale_table ";where temp_pro_current_date='"+date+"'where temp_pro_current_date='"+date+"'
        //SELECT temp_pro_current_date,temp_pro_child_id, category_name ,SUM(temp_pro_total_value) as sale_value FROM tempdatastore INNER JOIN product_data_insert_sale_table pdist ON pdist.p_code=tempdatastore.temp_pro_child_id INNER JOIN product_category_table pct ON pct.category_id=pdist.categoryid where temp_pro_current_date BETWEEN '2016-10-02' AND '2016-10-10' GROUP BY category_name

        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public Cursor getTemp(String fromDate) {
        Cursor cursor;
        String quString = "SELECT temp_pro_current_date,SUM(temp_pro_total_value) as sale_value FROM tempdatastore where temp_pro_current_date= '" + fromDate + "'GROUP BY temp_pro_current_date";
        //String quString = "select p_value from product_data_insert_sale_table ";where temp_pro_current_date='"+date+"'where temp_pro_current_date='"+date+"'
        //SELECT temp_pro_current_date,temp_pro_child_id, category_name ,SUM(temp_pro_total_value) as sale_value FROM tempdatastore INNER JOIN product_data_insert_sale_table pdist ON pdist.p_code=tempdatastore.temp_pro_child_id INNER JOIN product_category_table pct ON pct.category_id=pdist.categoryid where temp_pro_current_date BETWEEN '2016-10-02' AND '2016-10-10' GROUP BY category_name

        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }


    // For Primary Sale
    public Cursor checkPrimaryOrderByGroup() {
        Cursor cursor;
        objSqliteDB = objDataBaseHelper.getReadableDatabase();

        String quString = "select * from "
                + Primary_Sale
                + " where delete_status=0 group by primary_order_id ";

        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    // For Isr
    public Cursor check_ISRDetail() {
        Cursor cursor;
        String quString = "select * from " + SYNC_ISR_Detail
                + " where isr_orderstatus='done' AND delete_status=0";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;

    }

    // For Retailer IMAGE
    public Cursor check_CustImg() {
        Cursor cursor;
        String quString = "select * from cust_img";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public Cursor check_MerchandiseImg() {
        Cursor cursor;
        String quString = "select * from Merchandise_TABLE where image!=''";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }


    public Cursor check_MerchandiseImg1() {
        Cursor cursor;
        String quString = "select * from Merchandise_TABLE where images_status=0";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public Cursor check_MerchandiseImg3() {
        Cursor cursor;
        String quString = "select * from Merchandise_REQUIREMTENT_TABLE where images_status=0";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public int check_MerchandiseDataExist(String orderId) {
        Cursor cursor;
        String quString = "select * from Merchandise_TABLE where orderid='" + orderId + "'";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor.getCount();
    }

    public Cursor getAllDealers_ss() {// /
        Cursor cur = objSqliteDB.rawQuery("SELECT " + ss_id + " as _id, "
                + ss_name + " from " + dealer_ss_table, new String[]{});
        return cur;
    }

    //	public List<Map<String, String>> getAllDealer(String ss_code) {
    //		List<Map<String, String>> dealerList = new ArrayList<Map<String, String>>();
    //
    //		Cursor cur = objSqliteDB.rawQuery("SELECT id,DealerName from "
    //				+ LOGIN_DEALER_TABLE + " where ss_id ='" + ss_code + "'", null);
    //		if (cur != null) {
    //			if (cur.moveToFirst()) {
    //				do {
    //					Map<String, String> delaerMap = new HashMap<String, String>();
    //					String dis_code = cur.getString(cur.getColumnIndex("id"));
    //					String dis_name = cur.getString(cur
    //							.getColumnIndex("DealerName"));
    //					delaerMap.put(dis_name, dis_code);
    //					dealerList.add(delaerMap);
    //				} while (cur.moveToNext());
    //			}
    //
    //		}
    //		return dealerList;
    //
    //	}


    public List<Map<String, String>> getAllDealer1() {
        List<Map<String, String>> dealerList = new ArrayList<Map<String, String>>();

        Cursor cur = objSqliteDB.rawQuery("SELECT id,DealerName from "
                + LOGIN_DEALER_TABLE, null);
        if (cur != null) {
            if (cur.moveToFirst()) {
                do {
                    Map<String, String> delaerMap = new HashMap<String, String>();
                    String dis_code = cur.getString(cur.getColumnIndex("id"));
                    String dis_name = cur.getString(cur
                            .getColumnIndex("DealerName"));
                    delaerMap.put(dis_name, dis_code);
                    dealerList.add(delaerMap);
                } while (cur.moveToNext());
            }

        }
        return dealerList;

    }

    public Cursor getAllDealerNotSelected(String ss_code) {
        Cursor cur = objSqliteDB.rawQuery("SELECT id,DealerName from "
                + LOGIN_DEALER_TABLE + " where ss_id ='" + ss_code + "'", null);
        return cur;
    }

    // For Attendance Image

    public Cursor getImgCountAttendence() {

        String p_query = "select * from attendance_store_table where images_status='0'";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;

    }

    public Cursor getImgCountDamage() {

        String p_query = "select * from Damage_Product where images_status='0' and damage_order_type=1";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;

    }

    public Cursor getImgCountRetailerDamage() {

        String p_query = "select * from Damage_Product where     damage_order_type=2 and images_status='0'";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;

    }

    //
    public Cursor getImgCountExpense() {

        String p_query = "select * from travelling_expense_bill where images_status='0'";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;

    }

    // For CallWise Image
    public Cursor check_Img() {
        Cursor cursor;
        String quString = "select * from callWise_img";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }


    // For Retailer Images
    public Cursor getRetailerImages() {
        Cursor cursor;
        String quString = "select * from " + retailer_images + " where images_status=0";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    /* SYNC METHOD END */
    // //////////////////////////////
    // For Isr
    public Cursor checkISRProducts(int grpid, String order_id) {
        Cursor cursor;
        String query = ("SELECT * from ISR_Detail where isr_group_id=" + grpid
                + " AND isr_order_id=" + order_id);
        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

    public void deleteISRpreviewdata(String Grpid, String orderid) {
        String str = ("DELETE from ISR_Detail WHERE isr_group_id = '" + orderid
                + "' AND isr_order_id='" + Grpid + "'");
        objSqliteDB.execSQL(str);
    }


    public int deleteNewRetailerData() {
        Cursor cursor;
        /*String str="select * from retailer_data_insert WHERE cCom = '0'";*/
        String str = "DELETE from retailer_data_insert WHERE cCom = '0'";
        cursor = objSqliteDB.rawQuery(str, null);

        int count = cursor.getCount();
        return count;
    }


    public boolean deleteTitle(String name) {
        return objSqliteDB.delete(LOGIN_RETAILER_TABLE, "cCom" + "=" + name, null) > 0;
    }

    public int checkuserfillanyproduct_isr(String orderid) {
        Cursor cursor;
        String query_str = "select * from ISR_Detail where isr_order_id='"
                + orderid + "' and delete_status ='0' ";
        cursor = objSqliteDB.rawQuery(query_str, null);
        int count = cursor.getCount();
        return count;

    }

    // For ISR
    public Cursor getAllIsr() {
        Cursor cursor = objSqliteDB.rawQuery(
                "SELECT id as _id, DealerName from " + LOGIN_ISR_TABLE,
                new String[]{});
        return cursor;

    }

    public int deleteIsrDataIfNotSubmitted(String tablename, String orderid,
                                           String status) {
        return objSqliteDB.delete(tablename, isr_order_id + "=?" + " AND "
                + isr_orderstatus + "=?", new String[]{orderid, status});
    }

    // For Damage And Replace


    public int deleteAllReplace(String time, String date) {
        return objSqliteDB.delete(SYNC_DAMAGE_REPLACE_TABLE, Time + "=?"
                + " AND " + Date + "=?", new String[]{time, date});
    }

    public long damage_replace(String d_code, String l_code, String c_code,
                               String reason_exc, String p_code, String p_qty, String p_mrp,
                               String p_value, String orderid, String damage_value, String time,
                               String date, String imei, String returnVal) {

        this.damage_replace_insert.bindString(1, d_code);
        this.damage_replace_insert.bindString(2, l_code);
        this.damage_replace_insert.bindString(3, c_code);
        this.damage_replace_insert.bindString(4, reason_exc);
        this.damage_replace_insert.bindString(5, p_code);
        this.damage_replace_insert.bindString(6, p_qty);
        this.damage_replace_insert.bindString(7, p_mrp);
        this.damage_replace_insert.bindString(8, p_value);
        this.damage_replace_insert.bindString(9, orderid);
        this.damage_replace_insert.bindString(10, damage_value);
        this.damage_replace_insert.bindString(11, time);
        this.damage_replace_insert.bindString(12, date);
        this.damage_replace_insert.bindString(13, imei);
        this.damage_replace_insert.bindString(14, returnVal);
        return this.damage_replace_insert.executeInsert();

    }

    public Cursor getImgCountComplaint() {
        String p_query = "select * from complaint_table where images_status = 0 and image!='' ";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);
        return cursor;
    }

    public long complaint_insert(String imei, String date, String time,
                                 String feedbackId, String complaint_type,
                                 String dealer_retailer_id, String message, String image,
                                 String order_id, String role_id, String name, String contact) {
        this.complaint_insert.bindString(1, imei);
        this.complaint_insert.bindString(2, date);
        this.complaint_insert.bindString(3, time);
        this.complaint_insert.bindString(4, feedbackId);
        this.complaint_insert.bindString(5, complaint_type);
        this.complaint_insert.bindString(6, dealer_retailer_id);
        this.complaint_insert.bindString(7, message);
        this.complaint_insert.bindString(8, image);
        this.complaint_insert.bindString(9, order_id);
        this.complaint_insert.bindString(10, role_id);
        this.complaint_insert.bindString(11, name);
        this.complaint_insert.bindString(12, contact);
        return this.complaint_insert.executeInsert();

    }

    public Cursor complaint_Types() {
        Cursor cs = objSqliteDB.rawQuery("SELECT com_Id as _id, com_name from "
                + LOGIN_COMPLAINT_TABLE, new String[]{});
        return cs;
    }

    public Cursor Feedback_FromTypes() {
        Cursor cs = objSqliteDB
                .rawQuery("SELECT feed_Id as _id, feed_name from "
                        + LOGIN_FEEDBACK_TABLE, new String[]{});
        return cs;
    }

    // For BalanceStock

    public Cursor getAddProductQuantityStatus(String prod_code) {
        Cursor cursor;
        String quntityText = "select balance_total_value from " + Balance_Stock
                + " where balance_product_code_='" + prod_code + "'";
        cursor = objSqliteDB.rawQuery(quntityText, null);
        return cursor;

    }

    // For Report Under Balance Stock
    public String GetBalanceUserName(String ID) {
        String params = String.valueOf(ID);
        Cursor c = objSqliteDB.query(SYNC_balance_report_userTable,
                new String[]{balance_report_userTable_id + " as _id",
                        balance_report_username},
                balance_report_userid + "=?", new String[]{params}, null,
                null, null);
        c.moveToFirst();
        int index = c.getColumnIndex(balance_report_username);
        return c.getString(index);
    }

    public String GetUserDealerName(String ID) {
        String params = String.valueOf(ID);
        String dealer_name = "", Str_dealer_name = "";
        Cursor cursor = objSqliteDB.query(SYNC_balance_report_userTable,
                new String[]{balance_report_userTable_id + " as _id",
                        balance_report_dealername}, balance_report_userid
                        + "=?", new String[]{params}, null, null, null);
        int count = cursor.getCount();
        if (count > 0) {
            if (cursor.moveToFirst()) {
                do {
                    dealer_name = cursor.getString(cursor
                            .getColumnIndex(balance_report_dealername));
                    ;
                } while (cursor.moveToNext());
            }
        }
        return dealer_name;
    }

    public Cursor getUser_balancestock_sku_preview(String user_id,
                                                   String dealer_id, String order_id) {
        String qry = "SELECT * from balance_sku_user_table  WHERE balance_sku_user_id='"
                + user_id + "' AND balance_sku_dealer_id='" + dealer_id + "' AND balance_sku_order_id='" + order_id + "'";
        return objSqliteDB.rawQuery(qry, null);
    }

    public Cursor get_user_balancestock_reports() {
        Cursor cur = objSqliteDB.rawQuery("SELECT " + balance_report_userid
                + " as _id, " + balance_report_username + ", "
                + balance_report_dealerid + " , " + balance_report_dealername
                + "  , " + balance_report_designation + "  from "
                + SYNC_balance_report_userTable, new String[]{});
        return cur;
    }

    public Cursor get_user_balancestock_sku_reports() {
        Cursor cur = objSqliteDB.rawQuery("SELECT " + balance_report_sku_userid
                + " as _id, " + balance_report_sku_productname + ", "
                + balance_report_sku_quantity + ", "
                + balance_report_sku_scheme + "  from "
                + SYNC_balance_report_sku_userTable, new String[]{});
        return cur;
    }

    // Common Method For Getting All Dealer
    public Cursor getAllDealers() {
        Cursor cur = objSqliteDB.rawQuery("SELECT id as _id, DealerName from "
                + LOGIN_DEALER_TABLE + " order by DealerName ", new String[]{});
        return cur;
    }

    public Cursor getAllsearchCategory(String like) {
        Cursor cur = objSqliteDB.rawQuery("SELECT category_id as _id, category_name from "
                + LOGIN_PRODUCT_CATAGORY_TABLE + " Where category_name like '%"
                + like
                + "%' order by category_name", new String[]{});
        return cur;
    }


    public Cursor getAllsearchClassification(String like) {
        Cursor cur = objSqliteDB.rawQuery("SELECT class_id as _id, class_name from "
                + LOGIN_Classification_TABLE + " Where class_name like '%"
                + like
                + "%' order by class_name", new String[]{});
        return cur;
    }

    public Cursor getAllsearchDealers(String like) {
        Cursor cur = objSqliteDB.rawQuery("SELECT id as _id, DealerName from "
                + LOGIN_DEALER_TABLE + " Where DealerName like '%"
                + like
                + "%' order by DealerName", new String[]{});
        return cur;
    }

    public Cursor getdealerdata(String dealer_id) {
        Cursor cursor;
        String qry = ("SELECT * from Dealer  where dealer_id='"
                + dealer_id + "'");
        cursor = objSqliteDB.rawQuery(qry, null);
        return cursor;
    }


    // Common Method For Getting All Retailers
    public Cursor getAllReatailers() {
        Cursor cursor = objSqliteDB.rawQuery(
                "SELECT c_code as _id, c_name from " + LOGIN_RETAILER_TABLE,
                new String[]{});
        return cursor;
    }

    // Common Method For Getting DealerWise Location

    public Cursor getAllJuniorList() {
        Cursor cursor = objSqliteDB.rawQuery(
                "SELECT j_id as _id, j_name from " + LOGIN_JUNIORUSER_TABLE,
                new String[]{});
        return cursor;
    }

    public Cursor check_location(String d_id) {
        Cursor cursor = null;
        try {
            String quString = "select l_name ,l_code as _id  from location_data_insert_sale_table where dis_id='"
                    + d_id + "'";
            /*"' order by l_name" ;*/
            cursor = objSqliteDB.rawQuery(quString, new String[]{});
        } catch (Exception e) {
            System.out.println(e);
        }

        return cursor;
    }

//    public Cursor check_location6(String d_id) {
//        Cursor cursor = null;
//        try {
//            String quString = "select isrname,dealerisr_name,isr_id from isruserdata where dealerisr_id='"
//                    + d_id + "'";
//            cursor = objSqliteDB.rawQuery(quString, new String[]{});
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return cursor;
//    }

    //Method For Getting ISR Name:-
    public Cursor ISR_Name(String d_id) {
        String q_query = "select * from " + LOGIN_ISRUSER_TABLE + " where dealerisr_id='" + d_id + "'";
        return objSqliteDB.rawQuery(q_query, null);
    }

    public Cursor check_stock(String p_id, String d_id) {
        Cursor cursor = null;
        try {
            String quString = "select * from product_stock where p_id="
                    + p_id + " AND d_id=" + d_id;

            cursor = objSqliteDB.rawQuery(quString, new String[]{});
        } catch (Exception e) {
            System.out.println(e);
        }

        return cursor;
    }

    public Cursor check_stock1(String p_id, String r_id) {
        Cursor cursor = null;
        try {
            String quString = "select AVG(temp_pro_qty) as temp_pro_qty from tempdatastore where temp_pro_child_id='"
                    + p_id + "'AND temp_pro_retailerid=" + r_id;
            /*"' order by l_name" ;*/
            cursor = objSqliteDB.rawQuery(quString, new String[]{});
        } catch (Exception e) {
            System.out.println(e);
        }

        return cursor;
    }

    public Cursor getTracking(String date) {
        Cursor cursor;
        String quString = "select  * from new_track where date='" + date + "'";

        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;

    }

    public Cursor check_location2() {
        Cursor cursor = null;
        try {
            String quString = "select l_name ,l_code as _id  from location_data_insert_sale_table";
            /*"' order by l_name" ;*/
            cursor = objSqliteDB.rawQuery(quString, new String[]{});
        } catch (Exception e) {
            System.out.println(e);
        }

        return cursor;
    }

    public Cursor getRetailerLatlong() {
        Cursor cursor = null;
        try {
            String quString = "select * from retailer_data_insert order by c_name ";
            /*"' order by l_name" ;*/
            cursor = objSqliteDB.rawQuery(quString, new String[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cursor;
    }


    public Cursor getRetailerLatlong(String b_id) {
        Cursor cursor = null;
        try {
            String quString = "select * from retailer_data_insert where l_id= '" + b_id + "'order by c_name";
            /*"' order by l_name" ;*/
            cursor = objSqliteDB.rawQuery(quString, new String[]{});
        } catch (Exception e) {
            System.out.println(e);
        }

        return cursor;
    }

    public Cursor getRetailerImage(String retailer_id) {
        Cursor cursor = null;
        try {
            String quString = "select  * from cust_img where retailer_id='" + retailer_id + "'";
            /*"' order by l_name" ;*/
            cursor = objSqliteDB.rawQuery(quString, new String[]{});
        } catch (Exception e) {
            System.out.println(e);
        }

        return cursor;
    }


    public Cursor getAlldailyreproting() {
        Cursor cur = objSqliteDB.rawQuery("SELECT id as _id, " + new_searching
                + " from " + LOGIN_DAILY_REPORTING, new String[]{});
        return cur;
    }

    public String[] getallbeat() {
        Cursor cur;
        String quString = "select l_name ,l_code as _id  from location_data_insert_sale_table  order by l_name";
        cur = objSqliteDB.rawQuery(quString, new String[]{});
        if (cur.getCount() > 0) {
            String[] str = new String[cur.getCount()];
            int i = 0;

            while (cur.moveToNext()) {
                str[i] = cur.getString(cur.getColumnIndex("l_name"));
                i++;
            }

            return str;

        } else {

            return new String[]{};
        }

    }

    public Cursor checkfilter_location1(String d_id) {
        Cursor cursor = null;
        try {
            String quString = "select l_name ,l_code as _id  from location_data_insert_sale_table where dis_id='"
                    + d_id + "'";
            //+ " order by l_name " ;
            cursor = objSqliteDB.rawQuery(quString, new String[]{});
        } catch (Exception e) {
            System.out.println(e);
        }

        return cursor;
    }

    public Cursor checkfilter_location(String d_id, String like) {
        Cursor cursor = null;
        try {
            String quString = "select l_name ,l_code as _id  from location_data_insert_sale_table where dis_id='"
                    + d_id + "' " + " AND l_name like '%"
                    + like
                    + "%'";
            //+ " order by l_name " ;
            cursor = objSqliteDB.rawQuery(quString, new String[]{});
        } catch (Exception e) {
            System.out.println(e);
        }

        return cursor;
    }


    public String getLocation(String locationId) {
        String beatName = "";
        try {
            String query = "select l_name from location_data_insert_sale_table where l_code='" + locationId + "'";
            Cursor cursor = objSqliteDB.rawQuery(query, new String[]{});

            if (cursor.getCount() > 0) {
                if (cursor.moveToFirst())
                    beatName = cursor.getString(cursor.getColumnIndex("l_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return beatName;
    }

    //	String quString = "select l_name ,l_code as _id  from location_data_insert_sale_table where dis_id='"
    //			+ d_id + "' "+" AND l_name like '%"
    //					+ like
    //					+ "%'"
    //					+ " order by l_name " ;
    //	++++++++++++++++++++++


    /*select c_code, c_name, count(c_code),l_id as retIdcount from retailer_data_insert where l_id=46*/
    public Cursor getRetailer(String beat_id, String like) {

        Cursor cursor;
        String quString = "select * from retailer_data_insert where l_id='"
                + beat_id + "'" + " AND c_name like '%"
                + like
                + "%'";
        //				+ " order by c_name ";
        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    public Cursor getRetailerComplaint() {

        Cursor cursor;
        String quString = "select * from retailer_data_insert ";

        //				+ " order by c_name ";
        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    public Cursor getRetailerDealerPaymentCollection(String l_id) {

        Cursor cursor;
        String quString = "select * from location_data_insert_sale_table where  l_code='" + l_id + "'";

        //				+ " order by c_name ";
        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }


    public Cursor getRetailerDealerNamePaymentCollection(String d_id) {

        Cursor cursor;
        String quString = "select * from Dealer where  id='" + d_id + "'";

        //				+ " order by c_name ";
        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    public Cursor getRetailerPaymentCollection(String d_id) {
        Cursor cursor = null;
        try {

            String quString = "select * from Payment_Collection_Data where  retailercode2='" + d_id + "'";

            //				+ " order by c_name ";
            cursor = objSqliteDB.rawQuery(quString, new String[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cursor;
    }

    /*  public Cursor getRetailer11(String beat_id) {

          Cursor cursor;
          String quString = "select * from retailer_data_insert where l_id='"
                  + beat_id + "' AND delete_retailer_status='1'";

          cursor = objSqliteDB.rawQuery(quString, new String[]{});

          return cursor;
      }*/
    public Cursor getRetailer11(String beat_id) {

        Cursor cursor;
        String quString = "select * from retailer_data_insert where l_id='"
                + beat_id + "' AND delete_retailer_status='1' order by seq_no";

        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }



    /*public Cursor getSearchedRetailer11(String beat_id, String searchRetailer) {

        Cursor cursor;
        String quString = "select * from retailer_data_insert where l_id='"
                + beat_id + "' and c_name like '%" + searchRetailer + "%' AND delete_retailer_status='1'";


        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }*/


    public Cursor getSearchedRetailer11(String beat_id, String searchRetailer) {

        Cursor cursor;
        String quString = "select * from retailer_data_insert where l_id='"
                + beat_id + "' and c_name like '%" + searchRetailer + "%' AND delete_retailer_status='1' order by seq_no";


        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    public Cursor getRetailerInformation(String retailerid) {

        Cursor cursor;
        String quString = "select   * from retailer_data_insert where c_code='"
                + retailerid + "'";

        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    public Cursor getRetailerInformation111() {

        Cursor cursor;
        String quString = "select   * from role_table1";

        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }


    public Cursor getRetailerTodaySale(String retailerid, String date) {

        Cursor cursor;
        String quString = ("select sum(temp_pro_total_value) as temp_pro_total_value from tempdatastore where temp_pro_current_date='" + date + "'" + " and temp_pro_retailerid='" + retailerid + "'");

        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    public Cursor getRetailerAcheivedTarget() {

        Cursor cursor;
        String quString = "select   * from LOGIN_RETAILER_TARGET_BEAT ";


        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    public Cursor getUserInformation() {

        Cursor cursor;
        String quString = "select * from constants_flag";

        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }


    public Cursor getCheckUserCompanyDetail() {

        Cursor cursor;
        String quString = "select * from user_company_detail";

        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }


    public Cursor getUserInformationmtp(String date) {
        Cursor cursor = null;
        if (objSqliteDB.isOpen()) {
            String quString = "select  * from mtpdata where date='" + date + "'";
            cursor = objSqliteDB.rawQuery(quString, new String[]{});
        }
        return cursor;
    }

    public Cursor getUserInformationmtp1(String date, String todate) {

        Cursor cursor;
        String quString = "select * from mtpdata where date BETWEEN '" + date + "' AND '" + todate + "'GROUP BY date";
        cursor = objSqliteDB.rawQuery(quString, new String[]{});
        return cursor;
    }

    public Cursor getUserInformation1(String userid) {

        Cursor cursor;
        String quString = "select   * from userimage where user_id='" + userid + "'";

        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    public Cursor getUserSale(String Date) {

        Cursor cursor;
        String quString = "select   Sum(temp_pro_total_value) as temp_pro_total_value from tempdatastore where temp_pro_current_date='" + Date + "'";

        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    public Cursor getRetailer(String like) {

        Cursor cursor;
        String quString = "select c_code, c_name from retailer_data_insert where c_name='"

                + like
                + "%'";
        //				+ " order by c_name ";
        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    //	public Cursor getRetailer(String bearid,String like) {
    //		Cursor cursor = null;
    //		try {
    //			String quString = "select l_name ,l_code as _id  from retailer_data_insert where l_id='"
    //					+ bearid + "' "+" AND l_name like '%"
    //							+ like
    //							+ "%'"
    //							+ " order by c_name " ;
    //			cursor = objSqliteDB.rawQuery(quString, new String[] {});
    //		} catch (Exception e) {
    //			System.out.println(e);
    //		}
    //
    //		return cursor;
    //	}
    //	public Cursor getRetailer(String beat_id,String like) {
    //
    //		Cursor cursor;
    //		String quString = "select c_code, c_name from retailer_data_insert where l_id='"
    //				+ beat_id + "'" +  " AND c_name like '%"
    //				+ like
    //				+ "%'"
    //				+ " order by c_name ";
    //		cursor = objSqliteDB.rawQuery(quString, null);
    //
    //		return cursor;
    //	}

	/*public int Retailercount(String date,String retailer)
    {

		String str=("Select * from tempdatastore where  temp_pro_current_date='"
				+ date + "'" + " AND retailer_name = '" + retailer + "'");

		Cursor cur=objSqliteDB.rawQuery(str, null);
		int count=cur.getCount();
		return count;
	}*/

    public Cursor Retailercount(String date, String retailer) {

        String str = ("select * from tempdatastore where temp_pro_current_date='" + date + "'" + " and temp_pro_retailerid='" + retailer + "'");

        Cursor cur = objSqliteDB.rawQuery(str, null);

        return cur;
    }

    public Cursor RetailercountWithProductive(String date, String retailer) {

        String str = ("select * from tempdatastore where temp_pro_current_date='" + date + "'" + " and temp_pro_retailerid='" + retailer + "' and booked_order_type='true'");

        Cursor cur = objSqliteDB.rawQuery(str, null);

        return cur;
    }

    public Cursor RetailercountWithProductive1(String date) {

        String str = ("select * from tempdatastore where temp_pro_current_date='" + date + "' and booked_order_type='true'" + " group by temp_pro_retailerid");

        Cursor cur = objSqliteDB.rawQuery(str, null);

        return cur;
    }

    public Cursor RetailercountWithNonProductiveProductive1(String date) {

        String str = ("select * from tempdatastore where temp_pro_current_date='" + date + "' and booked_order_type='false'" + " group by temp_pro_retailerid");

        Cursor cur = objSqliteDB.rawQuery(str, null);

        return cur;
    }

    public Cursor RetailercountWithNonProductiveProductive(String date, String retailer) {

        String str = ("select * from tempdatastore where temp_pro_current_date='" + date + "'" + " and temp_pro_retailerid='" + retailer + "' and booked_order_type='false'");

        Cursor cur = objSqliteDB.rawQuery(str, null);

        return cur;
    }

    public Cursor setTempStore(String retailerId, String orderId, String date, String product) {
        Cursor cursor;
        String Query_data = "select * from tempdatastore  where temp_pro_retailerid= '" + retailerId + "' and " + "temp_pro_order_id='" + orderId + "' and temp_pro_current_date2='" + date + "' and temp_pro_child_id='" + product + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;


    }

    public Cursor setTempStore2(String retailerId, String orderId, String date) {
        Cursor cursor;
        String Query_data = "select * from tempdatastore  where temp_pro_retailerid= '" + retailerId + "' and "
                + "temp_pro_order_id='" + orderId + "' and temp_pro_current_date='" + date + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    /*   public Cursor NotContactedCount(String date, String retailer) {

           String str = ("select * from reason where  date='"
                   + date + "'" + " AND retailer_id = '" + retailer + "'");

           Cursor cur = objSqliteDB.rawQuery(str, null);
           return cur;
       }*/
    public Cursor NotContactedCount(String date, String retailer) {

        String str = ("select * from reason where  date='"
                + date + "'" + " AND retailer_id = '" + retailer + "'AND retailer_id NOT IN (SELECT temp_pro_retailerid from tempdatastore WHERE temp_pro_current_date='" + date + "')");

        Cursor cur = objSqliteDB.rawQuery(str, null);
        return cur;
    }

    public Cursor NotContactedCount1(String date) {

        String str = "select * from reason where  date='"
                + date + "'";

        Cursor cur = objSqliteDB.rawQuery(str, null);
        return cur;
    }
    // Common Method For Getting All Product Category

    public Cursor getAllProductCategory() {
        Cursor cursor;
        String Query_data = "select *  from product_category_table ";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }


    // Get MTP target
    public Cursor getMtpTarget(String date, String todate) {

        Cursor cursor;
        String quString = "select * from mtpdata where date BETWEEN '" + date + "' AND '" + todate + "'GROUP BY date";
        cursor = objSqliteDB.rawQuery(quString, new String[]{});
        return cursor;
    }

    // Get Sale
    public Cursor getSales(String date) {
        Cursor cursor;
        String quString = "SELECT temp_pro_current_date,SUM(temp_pro_total_value) as total_sale_value FROM tempdatastore where temp_pro_current_date= '" + date + "'GROUP BY temp_pro_current_date";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }


    public Cursor getAllSchemeType(String pro_code) {
        Cursor cursor;
        String Query_data = "select *  from schemetype where  p_id='" + pro_code + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor getAllProductCategory1() {
        Cursor cursor;
        String Query_data = "select *  from product_category_table";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }


    public Cursor getAllProductCategory1(String retailerid) {
        Cursor cursor;
        String Query_data = "select temp_pro_categoryid,category_name  from product_category_table where temp_pro_retailer_id="
                + "retailerid" + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor getAlldamageProductCategory() {
        Cursor cursor;
        String Query_data = "select category_id,category_name  from damageproduct_category_table";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }
    // Common Method For Getting CategoryWise Product

    public String getTotalsome(String order_id) {


        Cursor cursor;

        String sum = "";
        String Query_data1 = "select SUM(temp_pro_total_value) as total_sum from tempdatastore where temp_pro_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data1, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    sum = cursor.getString(cursor.getColumnIndex("total_sum"));

                } while (cursor.moveToNext());

            }
        }

        cursor.close();
        return sum;
    }

    public String getTotalsomeRetailerStock(String order_id) {


        Cursor cursor;
        String sum = "";
        String Query_data1 = "select SUM(reta_pro_total_value) as total_sum from retailerbalancestock1 where reta_pro_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data1, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    sum = cursor.getString(cursor.getColumnIndex("total_sum"));

                } while (cursor.moveToNext());

            }
        }
        return sum;
    }


    public String getdamageTotalsome(String order_id) {
        Cursor cursor;
        String sum = "";
        String Query_data1 = "select SUM(damage_product_sale_value) as total_sum from Damage_Product where damage_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data1, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    sum = cursor.getString(cursor.getColumnIndex("total_sum"));

                } while (cursor.moveToNext());

            }
        }
        return sum;
    }


    public String getbalanceTotalsome(String order_id) {
        Cursor cursor;
        String sum = "";
        String Query_data1 = "select SUM(balance_cases) as total_sum from Balance_Stock where balance_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data1, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    sum = cursor.getString(cursor.getColumnIndex("total_sum"));

                } while (cursor.moveToNext());

            }
        }
        return sum;
    }

    public String getPrimarySaleTotalsome(String order_id) {
        Cursor cursor;
        String sum = "";
        String Query_data1 = "select SUM(primary_cases) as total_sum from Primary_Sale where primary_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data1, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    sum = cursor.getString(cursor.getColumnIndex("total_sum"));

                } while (cursor.moveToNext());

            }
        }
        return sum;
    }

    public Cursor getbalanceTotal(String order_id) {
        Cursor cursor;
        String Query_data1 = "select SUM(balance_cases) as total_case, SUM(value_str) as total_value from Balance_Stock where balance_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data1, null);

        return cursor;
    }

    public Cursor getPrimaryTotal(String order_id) {
        Cursor cursor;
        String Query_data1 = "select SUM(primary_cases) as total_case, SUM(value_str) as total_value from Primary_Sale where primary_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data1, null);

        return cursor;
    }

    public String getbalanceTotalsome11(String order_id) {
        Cursor cursor;
        String sum = "";
        String Query_data1 = "select SUM(balance_pieces) as total_sum from Balance_Stock where balance_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data1, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    sum = cursor.getString(cursor.getColumnIndex("total_sum"));

                } while (cursor.moveToNext());

            }
        }
        return sum;
    }


    public String getPrimaryTotalsome11(String order_id) {
        Cursor cursor;
        String sum = "";
        String Query_data1 = "select SUM(primary_pieces) as total_sum from Primary_Sale where primary_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data1, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    sum = cursor.getString(cursor.getColumnIndex("total_sum"));

                } while (cursor.moveToNext());

            }
        }
        return sum;
    }

    public String getTotalsome1(String order_id) {
        Cursor cursor;
        String sum = "";
        String Query_data1 = "select SUM(temp_pro_total_value) as total_sum from tempdatastore where temp_pro_retailerid='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data1, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    sum = cursor.getString(cursor.getColumnIndex("total_sum"));

                } while (cursor.moveToNext());

            }
        }
        return sum;
    }

    //	public Cursor getProductRegardingCategory(String category_id) {
    //		Cursor cursor_cat;
    //
    //		String Query_data1 = "select p_name from product_data_insert_sale_table where categoryid='"
    //				+ category_id + "' order by  prefpreference_id   ASC" ;
    //		cursor_cat = objSqliteDB.rawQuery(Query_data1, null);
    //
    //		return cursor_cat;
    //
    //	}

    public Cursor getProductRegardingCategory(String category_id) {
        Cursor cursor_cat;

        String Query_data1 = "select * from product_data_insert_sale_table where categoryid='"
                + category_id + "' order by  p_name";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }


    public Cursor getProductRegardingCategory1122(String category_id, String orderid) {
        Cursor cursor_cat;

        String Query_data1 = "select * from product_data_insert_sale_table where categoryid='"
                + category_id + "' AND p_code NOT IN (SELECT temp_pro_child_id from tempdatastore WHERE temp_pro_order_id='" + orderid + "')order by  p_name";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }


    public Cursor getProduct() {
        Cursor cursor_cat;

        String Query_data1 = "select * from gift ";

        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }

    public Cursor getProduct(String p_id) {
        Cursor cursor_cat;

        String Query_data1 = "select * from product_data_insert_sale_table where p_code='"
                + p_id + "'";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }

    public Cursor getProductRetailer(String retailer) {
        Cursor cursor_cat;

        String Query_data1 = "select * from tempdatastore where temp_pro_retailerid='"
                + retailer + "' order by  temp_pro_qty DESC";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }


    public Cursor getProductRetailerDate(String retailer) {
        Cursor cursor_cat;

        String Query_data1 = "select  (temp_pro_child_id) from tempdatastore where temp_pro_child_id='"
                + retailer + "' order by  temp_pro_qty DESC";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }


    public Cursor getProductRegardingCategory1(String category_id) {
        Cursor cursor_cat;

        String Query_data1 = "select * from product_data_insert_sale_table where categoryid='"
                + category_id + "' order by  p_name";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }

    public Cursor getProductRegardingCategory1111(String category_id, String orderid) {
        Cursor cursor_cat;

        String Query_data1 = "select * from product_data_insert_sale_table where categoryid='"
                + category_id + "' AND p_code NOT IN (SELECT reta_pro_child_id from retailerbalancestock1 WHERE reta_pro_order_id='" + orderid + "') order by  p_name";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }

    public Cursor getProductRegardingRetailer(String retailer_id) {
        Cursor cursor_cat;

        String Query_data1 = "select * from tempdatastore where temp_pro_retailerid='"
                + retailer_id + "' order by  temp_pro_child_name";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }


    public Cursor getProductRegardingProduct(String retailer_id) {
        Cursor cursor_cat;

        String Query_data1 = "select * from product_data_insert_sale_table where p_name='"
                + retailer_id + "'";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }

    public Cursor getProductRegardingCategory12(String categoryname) {
        Cursor cursor_cat;

        String Query_data1 = "select * from product_data_insert_sale_table where categoryname='"
                + categoryname + "' order by  p_name";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }


    public Cursor getProductRegardingCategory1gggg2(String categoryname, String orderid) {
        Cursor cursor_cat;

        String Query_data1 = "select * from product_data_insert_sale_table where categoryname='"
                + categoryname + "' AND p_code NOT IN (SELECT damage_product_code from Damage_Product WHERE damage_order_id='" + orderid + "') order by  p_name";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }

    //	qwerty
    //	public Cursor getProductRegardingCategory1(String category_id) {
    //		Cursor cursor_cat;
    //
    //		String Query_data1 = "select * from Product_table where ProductcategoryId='"
    //				+ category_id + "' order by  ProductName" ;
    //		cursor_cat = objSqliteDB.rawQuery(Query_data1, null);
    //
    //		return cursor_cat;
    //
    //	}


    public Cursor getdamageProductRegardingCategory(String category_id) {
        Cursor cursor_cat;

        String Query_data1 = "select * from damageproduct_data_insert_sale_table where p_code='"
                + category_id + "'";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }

    public int deleteNonbookedOrder(String tablename, String orderid,
                                    String status) {
        return objSqliteDB
                .delete(tablename, temp_pro_order_id + "=?" + " AND "
                        + temp_pro_orderstatus + "=?", new String[]{orderid,
                        status});
    }

    public int deleteRetailerReShuffle(String tablename, String orderid) {
        return objSqliteDB
                .delete(tablename, "order_id=?", new String[]{orderid});
    }

    public Cursor getSalesheadNotifiData() {
        Cursor cursor;

        String Query_data = "select * from " + SalesHeadNotifiTable;

        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public int checkuserfillanyproduct(String new_orderid) {
        Cursor cursor;
        String query_str = "select * from tempdatastore where temp_pro_order_id='"
                + new_orderid + "'";
        cursor = objSqliteDB.rawQuery(query_str, null);
        int count = cursor.getCount();
        cursor.close();
        return count;

    }

    public int checkuserisrfillanyproduct(String new_orderid) {
        Cursor cursor;
        String query_str = "select * from isrtempdatastore where isr_pro_order_id='"
                + new_orderid + "'";
        cursor = objSqliteDB.rawQuery(query_str, null);
        int count = cursor.getCount();

        return count;

    }

    public int checkuserfillanystockproduct(String new_orderid) {
        Cursor cursor;
        String query_str = "select * from retailerbalancestock1 where reta_pro_order_id='"
                + new_orderid + "'";
        cursor = objSqliteDB.rawQuery(query_str, null);
        int count = cursor.getCount();

        return count;

    }

    public Cursor checkPreviousRecord(String retailer_id, String status) {
        Cursor cursor;

        String Query_data = "select temp_pro_order_id from tempdatastore where temp_pro_retailerid='"
                + retailer_id + "' AND temp_pro_orderstatus='" + status + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor checkPreviousRecord1(String retailer_id, String status, String dealerId) {
        Cursor cursor;

        String Query_data = "select temp_pro_order_id from tempdatastore where temp_pro_retailerid='"
                + retailer_id + "' AND temp_pro_orderstatus='" + status + "' and temp_pro_dealerid='" + dealerId + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }


    public Cursor checkPreviousRecordForSpecificDate1(String retailer_id, String status, String dealerId, String date) {
        Cursor cursor;

        String Query_data = "select temp_pro_order_id from tempdatastore where temp_pro_retailerid='"
                + retailer_id + "' AND temp_pro_orderstatus='" + status + "' and temp_pro_dealerid='" + dealerId + "' and temp_pro_current_date='" + date + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor checkPreviousRecord1(String retailer_id, String status) {
        Cursor cursor;

        String Query_data = "select temp_pro_order_id from tempdatastore where temp_pro_retailerid='"
                + retailer_id + "' AND temp_pro_orderstatus='" + status + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public long MakingPreviousToCurrent_Order(String tablename,
                                              ContentValues cv, String previousorderid, String orderstatus) {
        long a = objSqliteDB.update(tablename, cv, temp_pro_order_id + "="
                + previousorderid + " AND temp_pro_orderstatus='" + orderstatus
                + "'", null);
        return a;
    }


    public Cursor check_product_code(String product_name) {
        Cursor cursor;
        String quString = "select * from product_data_insert_sale_table where p_name='"
                + product_name + "' order by  p_name";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public Cursor check_Fullfillmentproduct_code(String product_name) {
        Cursor cursor;
        String quString = "select * from FullfillmentReportProductTable where FullfillmentReportproductname='"
                + product_name + "' order by  FullfillmentReportproductname";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }


    public String getRetailerSchemeEnrollStatuSforannualbonding(String retailer_id) {
        Cursor cursor;
        String quString = "select status from "
                + RETAILER_SCHEME_ANNUAL_BONDING + " where retailer_id='" + retailer_id + "'";
        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        String schemeEnrollStatus = null;
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                schemeEnrollStatus = cursor.getString(cursor.getColumnIndex("status"));
            }
        }

        return schemeEnrollStatus;
    }

    public Cursor getRetailerInfo(String retailername) {
        Cursor cursor;
        String quString = "select * from FullfillmentReportProductTable where FullfillmentRetailerName='"
                + retailername + "'";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public String getRetailerSchemeEnrollStatuSfordiscoveryOutlet(String retailer_id) {
        Cursor cursor;
        String quString = "select status from "
                + RETAILER_SCHEME_DISCOVERY_OUTLET + " where retailer_id='" + retailer_id + "'";
        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        String schemeEnrollStatus = null;
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                schemeEnrollStatus = cursor.getString(cursor.getColumnIndex("status"));
            }
        }

        return schemeEnrollStatus;
    }

    public Cursor getRetailerTotalFulfillAmount(String id) {
        Cursor cursor;
        String quString = "select * from FullfillmentReportProductTable where FullfillmentReportproductRetailerId='"
                + id + "'";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public int deletetable(String Tablename) {
        return objSqliteDB.delete(Tablename, null, null);
    }

    public Cursor checkRetailerStockProduct(String order_id, String product_id) {
        String query = "SELECT reta_pro_order_id='" + order_id + "', reta_pro_child_id='" + product_id + "' FROM"
                + SYNC_RetailerStock;
        return objSqliteDB.rawQuery(query, null);
    }

    public Cursor check_damage_product_code(String product_name) {
        Cursor cursor;
        String quString = "select * from damageproduct_data_insert_sale_table where p_name='"
                + product_name + "'";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public Cursor checkProducts(String grpid, String order_id) {
        Cursor cursor;
        String qry = ("SELECT * from " + SYNC_tempdatastore
                + " where temp_pro_grpId_childId='" + grpid
                + "' AND temp_pro_order_id='" + order_id + "'");
        cursor = objSqliteDB.rawQuery(qry, null);
        return cursor;
    }


    public Cursor checkISRProducts(String grpid, String order_id) {
        Cursor cursor;
        String qry = ("SELECT * from " + SYNC_isrtempdatastore
                + " where isr_pro_grpId_childId='" + grpid
                + "' AND isr_pro_order_id='" + order_id + "'");
        cursor = objSqliteDB.rawQuery(qry, null);
        return cursor;
    }

    public void deletepreviewdata(String Grpid, String orderid) {
        String str = ("DELETE from tempdatastore WHERE  temp_pro_grpId_childId = '"
                + Grpid + "' AND temp_pro_order_id='" + orderid + "'");
        objSqliteDB.execSQL(str);
    }

    public String getproduct_value(String p_id) {
        String p_value = "";
        Cursor cursor;
        String quString = "select p_value from product_data_insert_sale_table where p_code='"
                + p_id + "'";
        cursor = objSqliteDB.rawQuery(quString, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    p_value = cursor
                            .getString(cursor.getColumnIndex("p_value"));
                } while (cursor.moveToNext());
            }
        }
        return p_value;
    }

    public Cursor getProductRate(String p_id) {
        String p_value = "";
        Cursor cursor;
        String quString = "select * from product_data_insert_sale_table where p_code='" + p_id + "'";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public String getdealer_value(String d_id) {
        String p_value = "";
        Cursor cursor;
        String quString = "select DealerName from Dealer where id='"
                + d_id + "'";
        cursor = objSqliteDB.rawQuery(quString, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    p_value = cursor
                            .getString(cursor.getColumnIndex("DealerName"));
                } while (cursor.moveToNext());
            }
        }
        return p_value;
    }

    public long UpdateOrderStatus(String tablename, ContentValues cv,
                                  String retailerid, String orderstatus) {
        long a = objSqliteDB.update(tablename, cv, temp_pro_retailerid + "="
                + retailerid + " AND temp_pro_orderstatus='" + orderstatus
                + "'", null);
        return a;
    }

    public long UpdateOrderStatus11(String tablename, ContentValues cv,
                                    String retailerid) {
        long a = objSqliteDB.update(tablename, cv, temp_pro_retailerid + "='"
                + retailerid
                + "'", null);
        return a;
    }

    public long UpdateOrderStatusforProduct(String tablename, ContentValues cv,
                                            String productid) {
        long a = objSqliteDB.update(tablename, cv, temp_pro_child_id + "="
                + productid, null);
        return a;
    }

    public long UpdateOrderStatusforProduct11(String tablename, ContentValues cv,
                                              String productid, String orderid) {
        long a = objSqliteDB.update(tablename, cv, temp_pro_child_id + "="
                + productid + " AND temp_pro_order_id=" + orderid, null);
        return a;
    }

    public long UpdateOrderStatusforBookProduct(String tablename, ContentValues cv,
                                                String productid, String t) {
        long a = objSqliteDB.update(tablename, cv, temp_pro_child_id + "="
                        + productid + " AND temp_pro_total_value=" + t
                , null);
        return a;
    }

    public Cursor getAllfillProduct111134(String qty, String scheme, String totalvalue, String p_id, String order_id) {
        Cursor cursor;

        String Query_data = "update  tempdatastore  set temp_pro_qty=" + qty + ",temp_pro_scheme="
                + scheme + ",temp_pro_total_value="
                + totalvalue + " where temp_pro_child_id='" + p_id
                + "' AND temp_pro_order_id=" + order_id;

        cursor = objSqliteDB.rawQuery(Query_data, null);

        int count = cursor.getCount();

        return cursor;

    }


    public long getAllfillProduct11211134(ContentValues cv, String p_id, String order_id, String qty) {
        Cursor cursor;
        long ab = objSqliteDB.update("tempdatastore", cv, temp_pro_child_id + "="
                        + p_id + " AND temp_pro_order_id=" + order_id + " AND temp_pro_qty!=" + qty
                , null);
        return ab;
    }


    public long getAllfillProduct11122211134(ContentValues cv, String p_id, String order_id) {
        long ab = objSqliteDB.update("tempdatastore", cv, temp_pro_child_id + "="
                + p_id + " AND temp_pro_order_id=" + order_id, null);
        return ab;

    }


    public long updateDeleteStatusForPreviousOrder(ContentValues cv, String p_id, String order_id) {
        Cursor cursor;
        long a = objSqliteDB.update("tempdatastore", cv, temp_pro_child_id + "="
                        + p_id + " AND temp_pro_order_id=" + order_id
                , null);

        /*String Query_data = "update  tempdatastore  set temp_pro_qty=" + qty + ",temp_pro_scheme="
                + scheme + ",temp_pro_total_value="
                + totalvalue + " where temp_pro_child_id='" + p_id
                + "' AND temp_pro_order_id=" + order_id;

        cursor = objSqliteDB.rawQuery(Query_data, null);

        int count = cursor.getCount();*/

        return a;

    }


    public Cursor getAllfillProduct111134dhdxd(String qty, String totalvalue, String p_id, String order_id) {
        Cursor cursor;

        String Query_data = "update  retailerbalancestock1  set reta_pro_qty=" + qty
                + ",reta_pro_total_value="
                + totalvalue + " where reta_pro_child_id='" + p_id
                + "' AND reta_pro_order_id=" + order_id;

        cursor = objSqliteDB.rawQuery(Query_data, null);

        int count = cursor.getCount();

        return cursor;

    }


    public Cursor getAllfillProduct111134dhdxd1111(String qty, String totalvalue, String p_id, String order_id) {
        Cursor cursor;

        String Query_data = "update  Damage_Product  set damage_product_quantity=" + qty
                + ",damage_product_sale_value="
                + totalvalue + " where damage_product_code='" + p_id
                + "' AND damage_order_id=" + order_id;

        cursor = objSqliteDB.rawQuery(Query_data, null);

        int count = cursor.getCount();

        return cursor;

    }


    public Cursor insertRetailerStockProduct(String qty, String totalValue, String p_id) {
        Cursor cursor;
        String Query_data = "UPDATE  retailerbalancestock1 set " +
                "reta_pro_qty='" + qty + "', " +
                "reta_pro_total_value='" + totalValue + "' " +
                "where reta_pro_child_id=" + p_id;

        cursor = objSqliteDB.rawQuery(Query_data, null);
        return cursor;
    }

    public void cancelOrder(String orderID) {
        objSqliteDB.execSQL("DELETE FROM "
                + SYNC_tempdatastore
                + " WHERE "
                + temp_pro_order_id + "= '" + orderID + "'");
    }

    public void cancelOrder2(String orderID) {
        objSqliteDB.execSQL("DELETE FROM "
                + SYNC_tempdatastore
                + " WHERE "
                + temp_pro_order_id + "= '" + orderID + "' and temp_pro_orderstatus='false'");
    }

    public String checkOrderStatus(String order_id) {
        String status = "";
        String query_str = "select temp_pro_orderstatus from tempdatastore where temp_pro_order_id='"
                + order_id + "'";
        Cursor cursor = objSqliteDB.rawQuery(query_str, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    status = cursor.getString(cursor
                            .getColumnIndex("temp_pro_orderstatus"));
                } while (cursor.moveToNext());

            }
        }
        if (status == null) {
            status = "";
        }

        return status;
    }

    public Cursor getAllfillProduct(String order_id) {
        Cursor cursor;

        String Query_data = "select * from tempdatastore where temp_pro_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }


    public int checkIfPreviousOrderDataExistInSameDate(String todayDate, String retailerId, String orderId) {
        Cursor cursor;

        String Query_data = "select * from tempdatastore where temp_pro_current_date='"
                + todayDate + "' and temp_pro_retailerid='" + retailerId + "' and temp_pro_order_id='" + orderId + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);
        return cursor.getCount();
        //return cursor;

    }

    public Cursor checkPreviousOrderDataExistInSameDate(String todayDate, String retailerId, String orderId) {
        Cursor cursor;

        String Query_data = "select * from tempdatastore where temp_pro_current_date='"
                + todayDate + "' and temp_pro_retailerid='" + retailerId + "' and temp_pro_order_id='" + orderId + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);
        return cursor;

    }

    public String getRetailerSchemeEnrollStatus(String retailer_id) {
        Cursor cursor;
        String quString = "select status from "
                + RETAILER_SCHEME_ENROLL + " where retailer_id='" + retailer_id + "'";
        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        String schemeEnrollStatus = null;
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                schemeEnrollStatus = cursor.getString(cursor.getColumnIndex("status"));
            }
        }

        return schemeEnrollStatus;
    }

    public Cursor getAllfillProduct1(String order_id) {
        Cursor cursor;

        String Query_data = "select * from tempdatastore where temp_pro_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor getAlldamageProduct1(String order_id) {
        Cursor cursor;

        String Query_data = "select * from Damage_Product where damage_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor getRetailerStock(String order_id) {
        Cursor cursor;
        String queryData = "SELECT reta_pro_child_name,reta_pro_stock_month, reta_pro_qty, reta_pro_child_id, reta_pro_total_value FROM retailerbalancestock1 where reta_pro_order_id='" +
                order_id + "'";
        cursor = objSqliteDB.rawQuery(queryData, null);
        return cursor;
    }

    public Cursor getAllbalnceProduct1(String order_id) {
        Cursor cursor;

        String Query_data = "select * from Balance_Stock where balance_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor getAllPrimarySaleProduct(String order_id) {
        Cursor cursor;

        String Query_data = "select * from Primary_Sale where primary_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor getAllProductive(String current_date) {
        Cursor cursor;

        String Query_data = "select * from tempdatastore where temp_pro_current_date='"
                + current_date + "' and booked_order_type='true'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor getAllNonProductive(String current_date) {
        Cursor cursor;

        String Query_data = "select * from tempdatastore where temp_pro_current_date='"
                + current_date + "' and booked_order_type='false'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor getAllNonConContacted(String current_date) {
        Cursor cursor;

        String Query_data = "select * from reason where date='"
                + current_date + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }


    public Cursor getAllfillProductRetailer(String order_id) {
        Cursor cursor;

        String Query_data = "select * from tempdatastore where temp_pro_retailerid='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }


    public long UpdateProduct(String tablename, ContentValues cv,
                              String orderid, String pid) {
        long a = objSqliteDB.update(tablename, cv, temp_pro_order_id + "="
                + orderid + " AND " + temp_pro_child_id + "=" + pid, null);
        return a;
    }

    public long UpdateProductDamage(String tablename, ContentValues cv,
                                    String orderid) {
        long a = objSqliteDB.update(tablename, cv, "damage_order_id" + "="
                + orderid, null);
        return a;
    }

    public long updateProductDetail(String tableName, ContentValues cv, int id, String columnId) {
        long a = objSqliteDB.update(tableName, cv, columnId + "='" + id + "'", null);
        return a;
    }


    public long UpdateDamageProduct(String tablename, ContentValues cv,
                                    String orderid, String pid) {

        long a = 0;
        try {
            a = objSqliteDB.update(tablename, cv, "damage_order_id" + "='"
                    + orderid + "' AND damage_product_code= " + pid, null);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }


    public Cursor getAllfillProduct111134dhdxd1233(String qty, String totalvalue, String p_id, String order_id) {
        Cursor cursor;

        String Query_data = "update  retailerbalancestock1  set reta_pro_qty=" + qty
                + ",reta_pro_total_value="
                + totalvalue + " where reta_pro_child_id='" + p_id
                + "' AND reta_pro_order_id=" + order_id;

        cursor = objSqliteDB.rawQuery(Query_data, null);

        int count = cursor.getCount();

        return cursor;

    }


    public void deleteRetailerStockProduct(String order_id, String product_id) {
        objSqliteDB.delete(SYNC_RetailerStock, reta_pro_order_id + "= '" + order_id +
                "' AND " + reta_pro_child_id + "= '" + product_id + "'", null);
    }

    public long deleteproductfrom_table(String tablename, String Order_id,
                                        String Prod_id) {
        long ststus = objSqliteDB.delete(tablename, temp_pro_order_id + "="
                + Order_id + " AND " + temp_pro_child_id + "=" + Prod_id, null);
        return ststus;
    }

    public long deleteproductfrom_damagetable(String tablename, String Order_id,
                                              String Prod_id) {
        long ststus = objSqliteDB.delete(tablename, "damage_order_id" + "="
                + Order_id + " AND " + "damage_product_code" + "=" + Prod_id, null);
        return ststus;
    }

    public int deleteCounterSaleOrder(String tablename, String orderid) {
        return objSqliteDB.delete(tablename, "counter_sale_order_id='" + orderid + "'", null);
    }

    public long deleteProduct(String tableName, int id, String colId) {
        long status = objSqliteDB.delete(tableName, colId + "='" + id + "'", null);
        return status;
    }


    public long UpdateOrderLocationData(String tablename, ContentValues cv,
                                        String orderid, String orderstatus) {
        long a = objSqliteDB.update(tablename, cv, temp_pro_order_id + "="
                        + orderid + " AND temp_pro_orderstatus='" + orderstatus + "'",
                null);
        return a;
    }

    // For GiftActivity

    public long addGifts(String gift, String gift_id, int qnty, String cust_id,
                         String orderId) {
        ContentValues cv = new ContentValues();
        cv.put("gift", gift);
        cv.put("gift_id", gift_id);
        cv.put("quantity", qnty);
        cv.put("Customer", cust_id);
        cv.put("orderId", orderId);
        long b = objSqliteDB.insert(SYNC_GIFT_TABLE, "id", cv);
        return b;
    }

    // For CallWise Image Insert
    public long callwise_img_insert(String c_code, String c_img, String l_name,
                                    String time, String imei, String date) {
        this.callwise_img_insert.bindString(1, c_code);
        this.callwise_img_insert.bindString(2, c_img);
        this.callwise_img_insert.bindString(3, l_name);
        this.callwise_img_insert.bindString(4, time);
        this.callwise_img_insert.bindString(5, imei);
        this.callwise_img_insert.bindString(6, date);
        return this.callwise_img_insert.executeInsert();

    }

    public Cursor getImgCount() {

        String p_query = "select * from callWise_img";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }

    public String[] getAllGift() {
        Cursor cursor = objSqliteDB.query(LOGIN_MARKETGIFT,
                new String[]{"gift"}, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            String[] str = new String[cursor.getCount()];
            int i = 0;

            while (cursor.moveToNext()) {
                str[i] = cursor.getString(cursor.getColumnIndex("gift"));
                i++;
            }

            return str;

        } else {

            return new String[]{};
        }
    }

    public Cursor check_gift_code(String gift_name) {
        Cursor cursor;
        String quString = "select gift_id from gifts where gift='" + gift_name
                + "'";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public int deleteAllImgCallWise() {

        return objSqliteDB.delete(SYNC_CALLWISE_IMAGE, null, null);
    }

    // Create Retailer

    public Cursor getMobileNumberOfRetailer(String number) {
        Cursor cursor = null;
        try {
            String quString = "select c_name from retailer_data_insert where cust_number ='"
                    + number + "'";
            cursor = objSqliteDB.rawQuery(quString, new String[]{});
        } catch (Exception e) {
            System.out.println(e);
        }

        return cursor;
    }

    public long cust_creation(long retalerid, String d_code, String l_code,
                              String c_name, String contact_name, String c_mob,
                              String create_date, String create_time, String imei,
                              String pin_str, String e_mail_str, String outlettype, String tin,
                              String lat, String longi, String imagename,
                              String mcc_mnc_lac_cellId, String adres_str, String customer_type, String seq_no,
                              String geo_add, String battery_status, String gps_status) {
        this.customer_store_insert.bindLong(1, retalerid);
        this.customer_store_insert.bindString(2, d_code);
        this.customer_store_insert.bindString(3, l_code);
        this.customer_store_insert.bindString(4, c_name);
        this.customer_store_insert.bindString(5, contact_name);
        this.customer_store_insert.bindString(6, c_mob);
        this.customer_store_insert.bindString(7, create_date);
        this.customer_store_insert.bindString(8, create_time);
        this.customer_store_insert.bindString(9, imei);
        this.customer_store_insert.bindString(10, pin_str);
        this.customer_store_insert.bindString(11, e_mail_str);
        this.customer_store_insert.bindString(12, outlettype);
        this.customer_store_insert.bindString(13, tin);
        this.customer_store_insert.bindString(14, lat);
        this.customer_store_insert.bindString(15, longi);
        this.customer_store_insert.bindString(16, imagename);
        this.customer_store_insert.bindString(17, mcc_mnc_lac_cellId);
        this.customer_store_insert.bindString(18, adres_str);
        this.customer_store_insert.bindString(19, customer_type);
        this.customer_store_insert.bindString(20, seq_no);
        this.customer_store_insert.bindString(21, geo_add);
        this.customer_store_insert.bindString(22, battery_status);
        this.customer_store_insert.bindString(23, gps_status);
        return this.customer_store_insert.executeInsert();

    }// End

    public long cust_img_insert(String retailer_id, String c_img,
                                String l_name, String time, String imei, String date) {
        this.cust_img_insert.bindString(1, retailer_id);
        this.cust_img_insert.bindString(2, c_img);
        this.cust_img_insert.bindString(3, l_name);
        this.cust_img_insert.bindString(4, time);
        this.cust_img_insert.bindString(5, imei);
        this.cust_img_insert.bindString(6, date);
        return this.cust_img_insert.executeInsert();

    }

    public Cursor getCustImgCount() {

        String p_query = "select * from cust_img";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }

    //	public Cursor getAllOutletTypes() {
    //		Cursor cs = objSqliteDB.rawQuery("SELECT id as _id, outlet_names from "
    //				+ LOGIN_OUTLETS, new String[] {});
    //		return cs;
    //	}
    public Cursor getAllOutletCategories() {
        Cursor cs = objSqliteDB.rawQuery("SELECT " + OutletCategoryCode + " as _id, " + OutletCategoryName + " from "
                + OutletCategoryTable, new String[]{});
        return cs;
    }


    public Cursor getAllOutletTypes() {
        Cursor cs = objSqliteDB.rawQuery("SELECT OutletTypeid1 as _id, OutletTypeName from "
                + OutletTypeTable, new String[]{});
        return cs;
    }

    public int deleteRetailerImg() {

        return objSqliteDB.delete(SYNC_RETAILER_IMAGE_TABLE, null, null);
    }

    // Retailer Brand

    public long insertOtherCompanyDetails(String cname, String gls, String ti,
                                          String cfl, String clum, String led, int dcode) {

        return 0;

    }

    public int deleteAllBrand() {
        return objSqliteDB.delete(SYNC_RETAILER_BRAND, null, null);
    }

    // For Daily Expense
    //Sahil
    //	public Cursor getAllTravellingModes() {
    //		Cursor cs = objSqliteDB.rawQuery(
    //				"SELECT id as _id, travelling_mode_names from "
    //						+ LOGIN_TRAVELLINGMODE, new String[] {});
    //		return cs;
    //	}

    public Cursor getAllTravellingModes() {
        Cursor cs = objSqliteDB.rawQuery(
                "SELECT TravellingModeId1 as _id, TravellingModeName from "
                        + TravellingMode_TABLE, new String[]{});
        return cs;
    }

    public Cursor checkAllValues(String date) {
        Cursor res;
        String quString = "select * from " + SYNC_balance_report_sku_userTable + " where balance_sku_today_date= " + date;
        res = objSqliteDB.rawQuery(quString, null);
        return res;
    }

    /* public long daily_report(String t_mode, String str_jrny, String end_jrny,
                              String tot_calls, String ta_exp, String da_exp, String misc_exp,
                              String tot_exp, String cr_date, String tim, String imei,
                              String order_id, String image, String image2, String image3,
                              String other_postage, String other_telecom, String latitude,
                              String longitude, String address, String mccmnccode,
                              String hotelrent, String beatcode,
                              String remark, String date) {
         this.daily_report_insert.bindString(1, t_mode);
         this.daily_report_insert.bindString(2, str_jrny);
         this.daily_report_insert.bindString(3, end_jrny);
         this.daily_report_insert.bindString(4, tot_calls);
         this.daily_report_insert.bindString(5, ta_exp);
         this.daily_report_insert.bindString(6, da_exp);
         this.daily_report_insert.bindString(7, misc_exp);
         this.daily_report_insert.bindString(8, tot_exp);
         this.daily_report_insert.bindString(9, cr_date);
         this.daily_report_insert.bindString(10, tim);
         this.daily_report_insert.bindString(11, imei);
         this.daily_report_insert.bindString(12, order_id);
         this.daily_report_insert.bindString(13, image);
         this.daily_report_insert.bindString(14, image2);
         this.daily_report_insert.bindString(15, image3);
         this.daily_report_insert.bindString(16, other_postage);
         this.daily_report_insert.bindString(17, other_telecom);

         this.daily_report_insert.bindString(18, latitude);
         this.daily_report_insert.bindString(19, longitude);
         this.daily_report_insert.bindString(20, address);
         this.daily_report_insert.bindString(21, mccmnccode);
         this.daily_report_insert.bindString(22, hotelrent);
         this.daily_report_insert.bindString(23, beatcode);
         this.daily_report_insert.bindString(24, remark);
         this.daily_report_insert.bindString(25, date);
         return this.daily_report_insert.executeInsert();

     }
 */
   /* // Daily Expense Image
    public long img_insert_daily_expense(String image1, String time,
                                         String imei, String date, String orderid, String image2,
                                         String image3) {
        this.img_insert_daily_expense.bindString(1, image1);
        this.img_insert_daily_expense.bindString(2, time);
        this.img_insert_daily_expense.bindString(3, imei);
        this.img_insert_daily_expense.bindString(4, date);
        this.img_insert_daily_expense.bindString(5, orderid);
        this.img_insert_daily_expense.bindString(6, image2);
        this.img_insert_daily_expense.bindString(7, image3);
        return this.img_insert_daily_expense.executeInsert();

    }
*/
    public int deleteAllImgDailyExpense() {

        return objSqliteDB.delete(SYNC_DAILYEXPENCE_IMAGE, null, null);
    }

    public int deleteTravellingmode() {

        return objSqliteDB.delete(TravellingMode_TABLE, null, null);
    }

    public int deleteAllTravellingmode() {

        return objSqliteDB.delete(LOGIN_TRAVELLINGMODE, null, null);
    }

    public int deleteAllNotification() {

        return objSqliteDB.delete(SYNC_NOTIFICATION, null, null);
    }

    public int deleteAllworkingstatus() {

        return objSqliteDB.delete(WorkngStatus_TABLE, null, null);
    }

    public int deleteAllurlList() {

        return objSqliteDB.delete(LOGIN_URL_LIST, null, null);
    }


    public int deleteAllRole() {

        return objSqliteDB.delete(LOGIN_ROLE1, null, null);
    }

    // For Damage And Replace

    public Cursor check_location_name(String l_code) {
        Cursor cursor;
        String quString = "select l_name ,l_code as _id  from location_data_insert_sale_table where l_code='"
                + l_code + "'";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public Cursor check_customer_code(String cust_name) {

        Cursor cursor;
        String quString = "select c_code from retailer_data_insert where c_name='"
                + cust_name + "'";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public Cursor check_beat_code(String beat) {

        Cursor cursor;
        String quString = "select l_code from location_data_insert_sale_table where l_name='"
                + beat + "'";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }


    public String[] getAllItemFilter(String lid) {
        Cursor cursor = objSqliteDB.query(LOGIN_RETAILER_TABLE,
                new String[]{"c_name"}, "l_id=" + lid, null, null, null,
                null);
        if (cursor.getCount() > 0) {
            String[] str = new String[cursor.getCount()];
            int i = 0;

            while (cursor.moveToNext()) {
                str[i] = cursor.getString(cursor.getColumnIndex("c_name"));
                i++;
            }
            return str;
        } else {
            return new String[]{};
        }
    }

    public String[] getAllRetailerItemFilter() {
        Cursor cursor = objSqliteDB.query(LOGIN_RETAILER_TABLE,
                new String[]{"c_name", "l_name"}, null, null, null, null,
                null);

        if (cursor.getCount() > 0) {
            String[] str = new String[cursor.getCount()];

            int i = 0;

            while (cursor.moveToNext()) {
                str[i] = cursor.getString(cursor.getColumnIndex("c_name"));

                i++;
            }

            return str;
        } else {
            return new String[]{};
        }
    }

    public String[] getAllProd() {
        Cursor cursor = objSqliteDB.query(LOGIN_PRODUCT_TABLE,
                new String[]{"p_name"}, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            String[] str = new String[cursor.getCount()];
            int i = 0;
            while (cursor.moveToNext()) {
                str[i] = cursor.getString(cursor.getColumnIndex("p_name"));
                i++;
            }
            return str;
        } else {

            return new String[]{};
        }
    }

    public String getDealer(int delercode) {
        Cursor cur = objSqliteDB.rawQuery(
                "select DealerName from Dealer where id=" + delercode, null);

        String delername = null;
        if (cur != null) {
            if (cur.moveToFirst()) {
                do {

                    delername = cur.getString(cur.getColumnIndex("DealerName"));
                } while (cur.moveToNext());
            }
        }
        return delername;
    }

    public Cursor getAllDamageReplaceRetailerName() {

        Cursor cur = objSqliteDB.rawQuery("SELECT " + damagereplaceretailer_id
                + " as _id, " + damagereplaceretailer_name + " from "
                + DamageReport_retailer, new String[]{});
        return cur;
    }

    public Cursor get_allDamageProduct(String r_id) {
        /*Cursor cur = objSqliteDB.rawQuery("SELECT " + DamageReport_pid
                + " as _id, " + DamageReport_name + ", " + DamageReport_qty
				+ ", " + DamageReport_mrp + ", " + DamageReport_value
				+ " from " + DamageReport_damage + " where damage_retailerid='"
				+ r_id + "'", new String[] {});
		 */// SUM(damage_value) as
        // damagetotalvalue
        Cursor cur = objSqliteDB.rawQuery("SELECT " + DamageReport_pid
                + " as _id, " + DamageReport_name + ",SUM(damage_qty) as "
                + DamageReport_qty + ",SUM(damage_mrp) as " + DamageReport_mrp
                + ",SUM(damage_value) as " + DamageReport_value + " from "
                + DamageReport_damage + " where damage_retailerid='" + r_id
                + "' group by damage_name", new String[]{});
        return cur;
    }

    public Cursor get_allReplaceProduct(String r_id) {
        Cursor cur = objSqliteDB.rawQuery("SELECT " + ReplaceReport_pid
                + " as _id, " + ReplaceReport_name + ", " + ReplaceReport_qty
                + ", " + ReplaceReport_mrp + ", " + ReplaceReport_value
                + " from " + ReplaceReport_replace
                + " where replace_retailerid='" + r_id + "'", new String[]{}); // SUM(replace_value)
        // as
        // replacetotalvalue
        return cur;
    }

    public Cursor get_tolalValue_Damage(String r_id) {
        String qry = "SELECT SUM(damage_value) as damagetotalvalue from "
                + DamageReport_damage + " where damage_retailerid= '" + r_id
                + "'";
        return objSqliteDB.rawQuery(qry, null);
    }

    public Cursor get_tolalValue_Replace(String r_id) {
        String qry = "SELECT SUM(replace_value) as replacetotalvalue from "
                + ReplaceReport_replace + " where replace_retailerid= '" + r_id
                + "'";
        return objSqliteDB.rawQuery(qry, null);
    }


    public Cursor get_scheme(String procode) {
        String qry = "SELECT scheme,scheme_qty  from product_data_insert_sale_table where p_code= ' " + procode + "'";


        return objSqliteDB.rawQuery(qry, null);
    }


    // Daily Sales Report

    public Cursor TotalReport(String date) {
        String qry = "select SUM(temp_pro_total_value) as totalsale , COUNT(DISTINCT temp_pro_child_name) as sku from "
                + SYNC_tempdatastore
                + " where temp_pro_current_date= '"
                + date
                + "' AND booked_order_type='true'";
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;
    }

    public Cursor getTemp1(String date) {
        Cursor cursor;
        String quString = "SELECT temp_pro_current_date,temp_pro_child_id, category_name ,SUM(temp_pro_total_value) as sale_value FROM tempdatastore INNER JOIN product_data_insert_sale_table pdist ON pdist.p_code=tempdatastore.temp_pro_child_id INNER JOIN product_category_table pct ON pct.category_id=pdist.categoryid where temp_pro_current_date='" + date + "' GROUP BY category_name";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;

    }


    public Cursor TotalReportRetailer(String date) {
        String qry = "select  retailer_name  ,temp_pro_child_name,temp_pro_qty,temp_pro_total_value from "
                + SYNC_tempdatastore
                + " where temp_pro_current_date= '"
                + date
                + "' AND booked_order_type='true'";
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;
    }

    public Cursor getParticularRetailerData(String date, String retailer_ID) {
        String qry = "select retailer_name ,temp_pro_child_name,temp_pro_qty,temp_pro_scheme,temp_pro_discount, temp_pro_total_value from "
                + SYNC_tempdatastore
                + " where temp_pro_current_date= '"
                + date
                + "' AND booked_order_type='true'"
                + " AND temp_pro_retailerid='"
                + retailer_ID + "'";
        return objSqliteDB.rawQuery(qry, null);
    }

    public Cursor TotalReportDealerRetailer(String date, String d_id) {
        String qry = "select  retailer_name, temp_pro_retailerid,temp_pro_child_name,temp_pro_qty,temp_pro_scheme,temp_pro_discount, temp_pro_total_value from "
                + SYNC_tempdatastore
                + " where temp_pro_current_date= '"
                + date
                + "' AND booked_order_type='true'"
                + " AND temp_pro_dealerid='" + d_id + "'";
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;
    }

    public Cursor ReportRetailer(String date, String retailerid) {
        String qry = "select  retailer_name  ,temp_pro_child_name,temp_pro_qty,temp_pro_total_value, temp_pro_scheme from "
                + SYNC_tempdatastore
                + " where temp_pro_current_date= '"
                + date
                + "' AND  temp_pro_retailerid= '"
                + retailerid
                + "' AND booked_order_type='true'";
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;
    }


    public Cursor sharedRetailerData(String date) {
        String qry = "select   temp_pro_retailer_name,SUM(temp_pro_total_value) as totalsale from "
                + SYNC_tempdatastore
                + " where temp_pro_current_date= '"
                + date
                + "' AND booked_order_type='true'";
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;
    }

    public Cursor getTotalActual(String date) {
        String qry = "select  DISTINCT temp_pro_beatid as locationcode,  temp_pro_dealerid as dealercode  from "
                + SYNC_tempdatastore
                + " where temp_pro_current_date= '"
                + date
                + "' AND booked_order_type='true'";
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;
    }

    public String getCount(String date) {
        Cursor cursor;
        String quString = "select count(DISTINCT temp_pro_order_id) as orderid from tempdatastore where temp_pro_current_date='"
                + date + "'" + " AND  booked_order_type= 'true'";
        String count = "0";
        cursor = objSqliteDB.rawQuery(quString, null);
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex("orderid"));
        }
        return count;
    }

    public String today_prod_nonprod(String date) {
        Cursor cursor;
        String quString = "select count(id) as id from tempdatastore where temp_pro_current_date = '"
                + date + "'" + " AND booked_order_type ='false'";
        String nonproductive = "0";
        cursor = objSqliteDB.rawQuery(quString, null);
        if (cursor.moveToFirst()) {
            nonproductive = cursor.getString(cursor.getColumnIndex("id"));
        }
        return nonproductive;

    }

    public Cursor totalsku1(String date, String dcode) {
        Cursor c;
        String qry = "select SUM(temp_pro_total_value) as totalsale ,SUM(temp_pro_qty)as totalqty , COUNT(DISTINCT temp_pro_child_name) as sku from "
                + SYNC_tempdatastore
                + " where temp_pro_current_date= '"
                + date
                + "' AND temp_pro_dealerid = '" + dcode + "'";

        c = objSqliteDB.rawQuery(qry, null);

        return c;
    }

    public Cursor today_cust_code11(String date, String customer) {
        String[] columns = new String[]{"(id) as _id",
                DataBaseManipulate.temp_pro_child_name,
                DataBaseManipulate.temp_pro_qty,
                DataBaseManipulate.temp_pro_total_value};

        Cursor c = objSqliteDB.query(DataBaseManipulate.SYNC_tempdatastore,
                columns, DataBaseManipulate.temp_pro_current_date + "=?"
                        + " AND " + DataBaseManipulate.temp_pro_retailer_name
                        + "=?" + " AND "
                        + DataBaseManipulate.temp_pro_child_name + "!=?",
                new String[]{date, customer, "Non Productive"}, null, null,
                null);
        return c;

    }

    public Cursor today_sku2(String date, String rcode, String qty, String dcode) {
        String qry = "select temp_pro_order_id  as _id, SUM(temp_pro_qty) as temp_pro_qty, SUM(temp_pro_total_value) as temp_pro_total_value ,SUM(temp_pro_scheme) as temp_pro_scheme ,temp_pro_child_name from "
                + SYNC_tempdatastore
                + " where "
                + temp_pro_current_date
                + "='"
                + date + "' AND temp_pro_retailerid = '" + rcode

                + "' AND booked_order_type != '" + qty + "' and temp_pro_dealerid='" + dcode

                + "' group by temp_pro_child_id order by  temp_pro_child_id";
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;

    }

    public Cursor dsrReportShowData(String date, String rcode, String qty, String dcode) {
        String qry = "select temp_pro_child_id,temp_pro_order_id, SUM(temp_pro_qty) as temp_pro_qty, " +
                "SUM(temp_pro_total_value) as temp_pro_total_value,temp_pro_scheme,temp_pro_child_name from "
                + SYNC_tempdatastore
                + " where "
                + temp_pro_current_date
                + "='"
                + date + "' AND temp_pro_retailerid = '" + rcode

                + "' AND booked_order_type != '" + qty + "' and temp_pro_dealerid='" + dcode

                + "' group by temp_pro_child_id order by  temp_pro_child_id";
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;

    }


   /* public Cursor get_all_grand_value(String time, String cid, String dealerId) {

        String str = "SELECT temp_pro_child_id  as _id, SUM(temp_pro_qty) as quantity, SUM(temp_pro_total_value)"
                + " as totalsalerate, SUM(temp_pro_scheme) as proscheme   from tempdatastore"
                + " Where temp_pro_current_date='"
                + time
                + "'  AND temp_pro_retailerid='" + cid + "' and booked_order_type != 'false' and temp_pro_dealerid ='" + dealerId + "' GROUP BY temp_pro_retailerid";

        return objSqliteDB.rawQuery(str, null);

    }*/

    public Cursor get_all_grand_value(String time, String cid, String dealerId) {

        String str = "SELECT temp_pro_child_id  as _id, SUM(temp_pro_qty) as quantity, SUM(temp_pro_total_value)"
                + " as totalsalerate, SUM(temp_pro_scheme) as proscheme   from tempdatastore"
                + " Where temp_pro_current_date='"
                + time
                + "'  AND temp_pro_retailerid='" + cid + "' and booked_order_type != 'false' and temp_pro_dealerid ='" + dealerId + "'";

        return objSqliteDB.rawQuery(str, null);

    }

    public Cursor get_all_grand_valu343e(String time, String cid, String dealerId) {

        String str = "SELECT temp_pro_child_id  as _id,temp_pro_qty, temp_pro_total_value"
                + " ,temp_pro_scheme    from tempdatastore"
                + " Where temp_pro_current_date='"
                + time
                + "' AND temp_pro_retailerid='" + cid + "' and booked_order_type != 'false' and temp_pro_dealerid ='" + dealerId + "'";

        return objSqliteDB.rawQuery(str, null);

    }


    public Cursor today_sku1(String date, String dcode) {

        String qry = "select (id) as _id , SUM(temp_pro_qty) as temp_pro_qty, SUM(temp_pro_total_value) as temp_pro_total_value , temp_pro_child_name from "
                + DataBaseManipulate.SYNC_tempdatastore
                + " where "
                + DataBaseManipulate.temp_pro_current_date
                + "='"
                + date
                + "' AND temp_pro_dealerid = '"
                + dcode
                + "'"
                + " AND booked_order_type='true'"
                + " group by "
                + temp_pro_child_name + " order by " + temp_pro_child_name;
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;

    }

    public Cursor today_sku_report_new(String date, String dcode) {

        String qry = "select (id) as _id ,SUM(temp_pro_qty) as temp_pro_qty,SUM(temp_pro_total_value) as temp_pro_total_value, temp_pro_child_name,temp_pro_child_id from "
                + DataBaseManipulate.SYNC_tempdatastore
                + " where "
                + DataBaseManipulate.temp_pro_current_date
                + "='"
                + date
                + "' AND temp_pro_dealerid = '"
                + dcode
                + "'"
                + " AND booked_order_type='true'"
                + " group by "
                + temp_pro_child_name + " order by " + temp_pro_child_name;
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;

    }


    public Cursor today_sku_report(String date, String dcode) {

        String qry = "select (id) as _id ,SUM(temp_pro_qty) as temp_pro_qty,SUM(temp_pro_total_value) as temp_pro_total_value,temp_pro_child_name from "
                + DataBaseManipulate.SYNC_tempdatastore
                + " where "
                + DataBaseManipulate.temp_pro_current_date
                + "='"
                + date
                + "' AND temp_pro_dealerid = '"
                + dcode
                + "'"
                + " AND booked_order_type='true'"
                + " group by "
                + temp_pro_child_name + " order by " + temp_pro_child_name;
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;

    }


    public Cursor today_classification1(String date, String dcode) {

        String qry = "select (id) as _id , SUM(temp_pro_qty) as temp_pro_qty, SUM(temp_pro_total_value) as temp_pro_total_value , temp_pro_child_name from "
                + DataBaseManipulate.SYNC_tempdatastore
                + " where "
                + DataBaseManipulate.temp_pro_current_date
                + "='"
                + date
                + "' AND temp_pro_classification_value = '"
                + dcode
                + "'"
                + " AND booked_order_type='true'"
                + " group by "
                + temp_pro_child_name + " order by " + temp_pro_child_name;
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;

    }

    public Cursor today_classification_report(String date, String dcode) {

        String qry = "select (id) as _id ,SUM(temp_pro_qty) as temp_pro_qty,SUM(temp_pro_total_value) as temp_pro_total_value,temp_pro_child_name from "
                + DataBaseManipulate.SYNC_tempdatastore
                + " where "
                + DataBaseManipulate.temp_pro_current_date
                + "='"
                + date
                + "' AND temp_pro_classification_value = '"
                + dcode
                + "'"
                + " AND booked_order_type='true'"
                + " group by "
                + temp_pro_child_name + " order by " + temp_pro_child_name;
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;

    }


    public Cursor ClassificationSku(String date, String dcode) {

        String qry = "select (id) as _id ,SUM(temp_pro_qty) as temp_pro_qty,SUM(temp_pro_total_value) as temp_pro_total_value, temp_pro_child_name from "
                + DataBaseManipulate.SYNC_tempdatastore
                + " where "
                + DataBaseManipulate.temp_pro_current_date
                + "='"
                + date
                + "' AND temp_pro_classification_value = '"
                + dcode
                + "'"
                + " AND booked_order_type='true'"
                + " group by "
                + temp_pro_child_name + " order by " + temp_pro_child_name;
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;

    }

    public Cursor today_classification(String date, String dcode) {

        String qry = "select (id) as _id , SUM(temp_pro_qty) as temp_pro_qty, SUM(temp_pro_total_value) as temp_pro_total_value , temp_pro_child_name from "
                + DataBaseManipulate.SYNC_tempdatastore
                + " where "
                + DataBaseManipulate.temp_pro_current_date
                + "='"
                + date
                + "' AND temp_pro_dealerid = '"
                + dcode
                + "'"
                + " AND booked_order_type='true'"
                + " group by "
                + temp_pro_child_name + " order by " + temp_pro_child_name;
        Cursor c = objSqliteDB.rawQuery(qry, null);
        return c;

    }


    public Cursor get_all_grand_sku2(String time, String dcode) {

        String str = "SELECT id  as _id, SUM(temp_pro_qty) as temp_pro_qty, SUM(temp_pro_total_value)"
                + " as temp_pro_total_value from tempdatastore"
                + " Where temp_pro_current_date='"
                + time
                + "' AND  temp_pro_dealerid='" + dcode + "'";

        return objSqliteDB.rawQuery(str, null);

    }

    public Cursor get_all_grand_classification(String time, String dcode) {

        String str = "SELECT id  as _id, SUM(temp_pro_qty) as quantity, SUM(temp_pro_total_value)"
                + " as totalsalerate from tempdatastore"
                + " Where temp_pro_current_date='"
                + time
                + "' AND  temp_pro_classification_value='" + dcode + "'";

        return objSqliteDB.rawQuery(str, null);

    }

    public Cursor get_all_sku_product(String time, String dcode) {

        String str = "SELECT id  as _id,temp_pro_qty,temp_pro_total_value,temp_pro_child_name"
                + "from tempdatastore"
                + " Where temp_pro_current_date='"
                + time
                + "' AND  temp_pro_classification_value='" + dcode + "'";

        return objSqliteDB.rawQuery(str, null);

    }

    public Cursor getSameProductRegardingCategory(String category_id) {
        Cursor cursor_cat;

        String Query_data1 = "select Distinct(temp_pro_child_name) from tempdatastore where temp_pro_category_id='"
                + category_id + "' order by  temp_pro_child_name";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }

    public Cursor getFocusProductRegardingCategory(String category_id) {
        Cursor cursor_cat;

        String Query_data1 = "select Distinct(temp_pro_child_name) from tempdatastore where temp_pro_category_id='"
                + category_id + "' order by  temp_pro_child_name";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }

    public Cursor getAllSameProductCategory(String Retailer) {
        Cursor cursor;
        String Query_data = "select Distinct(temp_pro_category_id),temp_pro_category_name from tempdatastore where temp_pro_retailerid='"
                + Retailer + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }


    public Cursor getAllSameProductCategory111(String Retailer) {
        Cursor cursor;
        String Query_data = "select  * from tempdatastore where temp_pro_retailerid='"
                + Retailer + "'AND temp_pro_child_id NOT IN (select ProductId1 from Product_table where focus=1) group by temp_pro_child_id";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }


    public Cursor getFocusProductCategory() {
        Cursor cursor;
        String Query_data = "select   * from product_data_insert_sale_table where focus=1";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor schemeReportRetailer() {
        Cursor cursor;
        String Query_data = "select   * from percentscheme";

        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor getSale() {
        Cursor cursor;
        String quString = "select Sum(temp_pro_total_value) as temp_pro_total_value,temp_pro_current_date from tempdatastore GROUP BY temp_pro_current_date";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public Cursor getTotalCall(String date) {
        Cursor cursor;
        String quString = "select Count(temp_pro_retailerid) as total_call from tempdatastore where temp_pro_current_date='”+ date +“' AND booked_order_type='true'";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public Cursor getTotalCall11(String date) {
        Cursor cursor;
        String quString = "select Distinct(temp_pro_retailerid)  from tempdatastore where temp_pro_current_date='" + date + "'";
        cursor = objSqliteDB.rawQuery(quString, null);
        int count = cursor.getCount();

        return cursor;
    }


    public Cursor getFocusProductCategory111() {
        Cursor cursor;
        String Query_data = "select    * from Product_table where focus=1";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor getRetailerDeleteStatus() {
        Cursor cursor;
        String Query_data = "select * from retailer_data_insert where delete_retailer_status='0'";
        cursor = objSqliteDB.rawQuery(Query_data, null);
        return cursor;
    }

    public Cursor getFocusProductCategory11(String Catregory) {
        Cursor cursor;
        String Query_data = "select  * from product_data_insert_sale_table where categoryid='" + Catregory + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }


    public Cursor get_all_grand_sku(String time, String dcode) {

        String str = "SELECT id  as _id, SUM(temp_pro_qty) as quantity, SUM(temp_pro_total_value)"
                + " as totalsalerate from tempdatastore"
                + " Where temp_pro_current_date='"
                + time
                + "' AND  temp_pro_dealerid='" + dcode + "'";

        return objSqliteDB.rawQuery(str, null);

    }

  /*  public Cursor today_dealerwisecust_recordAll(String date, String dcode) {
        Cursor cursor;
        String quString = "select distinct(retailer_name) , temp_pro_retailerid,booked_order_type  from tempdatastore where temp_pro_current_date='"
                + date + "'" + " AND temp_pro_dealerid = '" + dcode + "'" + " AND  booked_order_type!='null' and delete_retailer_status=0 AND  booked_order_type!=' '";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }*/


    public Cursor today_dealerwisecust_recordAll(String date, String dcode) {
        Cursor cursor;
        String quString = "select retailer_data_insert.c_name as retailer_name , " +
                "temp_pro_retailerid,booked_order_type  from tempdatastore left join" +
                " retailer_data_insert ON" +
                " retailer_data_insert.c_code = tempdatastore.temp_pro_retailerid " +
                "where temp_pro_current_date='"
                + date + "'" + " AND temp_pro_dealerid = '" + dcode + "'" + " AND" +
                "  booked_order_type!='null'  AND  booked_order_type!=' ' group by temp_pro_retailerid";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

  /*  public Cursor today_dealerwisecust_record(String date, String dcode) {
        Cursor cursor;
        String quString = "select distinct(retailer_name) , temp_pro_retailerid ,booked_order_type  from tempdatastore where temp_pro_current_date='"
                + date + "'" + " AND temp_pro_dealerid = '" + dcode + "'"

                + " AND  booked_order_type='true'";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }*/

    public Cursor today_dealerwisecust_record(String date, String dcode) {
        Cursor cursor;
        String quString = "select retailer_data_insert.c_name as retailer_name , temp_pro_retailerid ,booked_order_type  from tempdatastore left join retailer_data_insert ON retailer_data_insert.c_code = tempdatastore.temp_pro_retailerid where temp_pro_current_date='"
                + date + "'" + " AND temp_pro_dealerid = '" + dcode + "'"

                + " AND  booked_order_type='true' group by temp_pro_retailerid ";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    // For MTP
    public Cursor getMTPConstants() {

        String p_query = "select mtpapproverequire, mtpextended, buffurdays from "
                + LOGIN_CONSTANT_DELETE;
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }


    public Cursor getDeleteStatusDetail() {
        String p_query = "select * from retailerDeleteStatusTable";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }

    public Cursor getTotalCountDsrSale(String date) {
        Cursor curs;
        String quString = "select count(Distinct(temp_pro_retailerid)) as totalretailer from " + SYNC_tempdatastore + " where temp_pro_current_date = '" + date + "'";

		/*String quString="select count(Distinct(temp_pro_retailerid))"
                + "as r_id from "+SYNC_tempdatastore+ " where temp_pro_current_date = '"+date+"'";*/
        curs = objSqliteDB.rawQuery(quString, null);
        return curs;
    }

    public Cursor getTotalCountDsrSale(String date, String d_id) {
        Cursor curs;
        String quString = "select count(Distinct(temp_pro_retailerid)) as totalretailer from " + SYNC_tempdatastore + " where temp_pro_current_date = '" + date + "'AND temp_pro_dealerid=" + d_id;

		/*String quString="select count(Distinct(temp_pro_retailerid))"
                + "as r_id from "+SYNC_tempdatastore+ " where temp_pro_current_date = '"+date+"'";*/
        curs = objSqliteDB.rawQuery(quString, null);
        return curs;
    }


    public Cursor getStartAndEndDate() {
        Cursor curs;
        String quString = "select * from " + LOGIN_RETAILER_TARGET_BEAT;

		/*String quString="select count(Distinct(temp_pro_retailerid))"
                + "as r_id from "+SYNC_tempdatastore+ " where temp_pro_current_date = '"+date+"'";*/
        curs = objSqliteDB.rawQuery(quString, null);
        return curs;
    }


    public Cursor getStatus(String retailerId) {
        Cursor curs;
        String quString = "select * from " + RETAILER_TARGET_BEAT2 + "where retailer_id='" + retailerId + "'";

		/*String quString="select count(Distinct(temp_pro_retailerid))"
                + "as r_id from "+SYNC_tempdatastore+ " where temp_pro_current_date = '"+date+"'";*/
        curs = objSqliteDB.rawQuery(quString, null);
        return curs;
    }

    public Cursor getBeat_id(String date) {
        Cursor curs;
        String quString = "select  * from tempdatastore where temp_pro_current_date2=" + date;

		/*String quString="select count(Distinct(temp_pro_retailerid))"
                + "as r_id from "+SYNC_tempdatastore+ " where temp_pro_current_date = '"+date+"'";*/
        curs = objSqliteDB.rawQuery(quString, null);
        int count = curs.getCount();
        return curs;
    }

    public Cursor getBeat_Name(String b_id) {
        Cursor curs;
        String quString = "select  * from location_data_insert_sale_table where l_code=" + b_id;

        curs = objSqliteDB.rawQuery(quString, null);
        return curs;
    }

    public Cursor getdealer_Name(String b_id) {
        Cursor curs;
        String quString = "select  * from Dealer where id=" + b_id;

        curs = objSqliteDB.rawQuery(quString, null);
        return curs;
    }

    //Method to delete Retailer After selection from listview:-
    public Cursor deleteRetailer(String retailerid) {
        Cursor curs;
        String quString = "DELETE from retailer_data_insert where c_id='"
                + retailerid + "'";
        curs = objSqliteDB.rawQuery(quString, null);
        return curs;
    }

    public Cursor getPersonRole_Name(String b_id) {
        Cursor curs;
        String quString = "select  * from role_table1 where r_id=" + b_id;

        curs = objSqliteDB.rawQuery(quString, null);
        int count = curs.getCount();
        return curs;
    }

    public Cursor getattandance_Type(String date) {
        Cursor curs;
        String quString = "select  * from attendance_store_table where attn_date= '" + date + "'";
        curs = objSqliteDB.rawQuery(quString, null);
        int count = curs.getCount();
        return curs;
    }

    public Cursor getattandance_id(String attan) {
        Cursor curs;
        String quString = "select  * from WorkingStatus_table where WorkingStatusId1=" + attan;
        curs = objSqliteDB.rawQuery(quString, null);
        int count = curs.getCount();
        return curs;
    }

    public Cursor getrdsname(String date) {
        Cursor curs;
        String quString = "select  * from tempdatastore where temp_pro_current_date= '" + date + "'";
        curs = objSqliteDB.rawQuery(quString, null);
        int count = curs.getCount();
        return curs;
    }

    public Cursor getRetailer_Count(String b_id) {
        Cursor curs;
        String quString = "select *  from retailer_data_insert where l_id='" + b_id + "'";

        curs = objSqliteDB.rawQuery(quString, null);
        return curs;
    }

    public Cursor getProductiveRetailer_Count(String date) {
        Cursor curs;
        String quString = "select  temp_pro_retailerid from tempdatastore where temp_pro_current_date= '" + date + "'";
        curs = objSqliteDB.rawQuery(quString, null);
        int count = curs.getCount();


        return curs;
    }

    public Cursor getNewProductiveRetailer_Count(String retailer) {
        Cursor curs;
        String quString = "select  SUM(temp_pro_total_value) as temp_pro_total_value from tempdatastore where temp_pro_retailerid= '" + retailer + "'";
        curs = objSqliteDB.rawQuery(quString, null);
        int count = curs.getCount();


        return curs;
    }
/*===========
    public Cursor getNewProductiveRetailer_Count(String date) {
        Cursor curs;
        String quString = "select  SUM(temp_pro_total_value) as temp_pro_total_value from tempdatastore where temp_pro_current_date= '"+date+"'";
        curs = objSqliteDB.rawQuery(quString, null);
        int count=curs.getCount();


        return curs;
    }*/

    public Cursor getNewProductiveRetailer_Count1(String retailer) {
        Cursor curs;
        String quString = "select  SUM(temp_pro_total_value) as temp_pro_total_value from tempdatastore where temp_pro_retailerid= '" + retailer + "'group by temp_pro_retailerid";
        curs = objSqliteDB.rawQuery(quString, null);
        int count = curs.getCount();


        return curs;
    }

    public Cursor getNewRetailer_Count(String date) {
        Cursor curs;
        String quString = "select  retailer_id from customer_store_table where create_date= '" + date + "'";
        curs = objSqliteDB.rawQuery(quString, null);
        int count = curs.getCount();


        return curs;
    }

    public Cursor getNewRetailer_Count2(String date) {
        Cursor curs;
        String quString = "select  count(DISTINCT(retailer_id)) as newRetailerCount from customer_store_table where create_date= '" + date + "'";
        curs = objSqliteDB.rawQuery(quString, null);
        int count = curs.getCount();


        return curs;
    }

    public Cursor getNewRetailerBilledAmount(String date) {
        Cursor curs;
        String quString = "select  SUM(tempdatastore.temp_pro_total_value) as TotalVAlue from customer_store_table INNER JOIN tempdatastore ON customer_store_table.retailer_id=tempdatastore.temp_pro_retailerid where create_date='" + date + "'";
        curs = objSqliteDB.rawQuery(quString, null);
        int count = curs.getCount();


        return curs;
    }

    public Cursor getNewRetailerBilledCount(String date) {
        Cursor curs;
        String quString = "select  Count(DISTINCT(customer_store_table.retailer_id)) as  totalRetailerCount from customer_store_table INNER JOIN tempdatastore ON customer_store_table.retailer_id=tempdatastore.temp_pro_retailerid where create_date='" + date + "'";
        curs = objSqliteDB.rawQuery(quString, null);
        int count = curs.getCount();


        return curs;
    }

    public Cursor getNewRetailerCount(String date) {
        Cursor curs;
        String quString = "select  Count(DISTINCT(retailer_id)) As newRetailerCount from customer_store_table where create_date='" + date + "'";
        curs = objSqliteDB.rawQuery(quString, null);
        int count = curs.getCount();


        return curs;
    }


    public Cursor getRetailer_ProductiveCount(String date, String b_id) {
        Cursor curs;
        String quString = "select  Count from tempstoredata where l_id=" + date + "' AND b_id=" + b_id;

		/*String quString="select count(Distinct(temp_pro_retailerid))"
                + "as r_id from "+SYNC_tempdatastore+ " where temp_pro_current_date = '"+date+"'";*/
        curs = objSqliteDB.rawQuery(quString, null);
        return curs;
    }

    public Cursor getRetailer_NewAmountCount(String date, String b_id) {
        Cursor curs;
        String quString = "select  SUM(temp_pro_total_value) as temp_pro_total_value from tempstoredata where l_id=" + date + "' AND b_id=" + b_id;

		/*String quString="select count(Distinct(temp_pro_retailerid))"
                + "as r_id from "+SYNC_tempdatastore+ " where temp_pro_current_date = '"+date+"'";*/
        curs = objSqliteDB.rawQuery(quString, null);
        return curs;
    }


    public Cursor getProductiveCountDsrSale(String date) {
        Cursor curs;
        String quString = "select count(Distinct(temp_pro_retailerid)) as totalproductiveretailer "
                + "from " + SYNC_tempdatastore + "" + " where temp_pro_current_date = '" +
                date + "' and booked_order_type != 'false'";

		/*String quString="select count(Distinct(temp_pro_retailerid))"
                + "as r_id from "+SYNC_tempdatastore+ " where temp_pro_current_date = '"+date+"' and temp_prostatus='Productive'";
		 */
        curs = objSqliteDB.rawQuery(quString, null);
        return curs;
    }

    public Cursor getRetailerDsrSale(String date, String retailer_id) {
        Cursor curs;
        String quString = "select  retailer_name,temp_pro_child_name,temp_pro_qty,temp_pro_total_value "
                + "from " + SYNC_tempdatastore + "" + " where temp_pro_current_date = '" +
                date + "' and temp_pro_retailerid='" + retailer_id + "'";

		/*String quString="select count(Distinct(temp_pro_retailerid))"
                + "as r_id from "+SYNC_tempdatastore+ " where temp_pro_current_date = '"+date+"' and temp_prostatus='Productive'";
		 */
        curs = objSqliteDB.rawQuery(quString, null);
        return curs;
    }

    public Cursor getprimarysharedata(String date, String dealer_id) {
        Cursor cursor;
        String qry = ("SELECT * from Primary_Sale  where primary_current_date='"
                + date + "' AND primary_dealer_id ='" + dealer_id + "'");
        cursor = objSqliteDB.rawQuery(qry, null);
        return cursor;
    }


    public Cursor get_distributor_stock_sharedata(String date, String dealer_id) {
        Cursor cursor;
        String qry = ("SELECT * from Balance_Stock  where balance_current_date='"
                + date + "' AND balance_dealer_id ='" + dealer_id + "'");
        cursor = objSqliteDB.rawQuery(qry, null);
        return cursor;
    }


    public Cursor getCountNoti() {
        Cursor cursor;
        String qry = ("SELECT * from count_table_noti");
        cursor = objSqliteDB.rawQuery(qry, null);
        return cursor;
    }

    public List<Map<String, String>> getAllDealer(String town_id) {
        List<Map<String, String>> dealerList = new ArrayList<Map<String, String>>();

        Cursor cur = objSqliteDB.rawQuery("SELECT id,DealerName from "
                + LOGIN_DEALER_TABLE + " where town_id='" + town_id + "'", null);
        if (cur != null) {
            if (cur.moveToFirst()) {
                do {
                    Map<String, String> delaerMap = new HashMap<String, String>();
                    String dis_code = cur.getString(cur.getColumnIndex("id"));
                    String dis_name = cur.getString(cur
                            .getColumnIndex("DealerName"));
                    delaerMap.put(dis_name, dis_code);
                    dealerList.add(delaerMap);
                } while (cur.moveToNext());
            }

        }
        return dealerList;

    }

    public List<Map<String, String>> getAllLocation(String dis_code) {
        List<Map<String, String>> locationList = new ArrayList<Map<String, String>>();
        Cursor cur = objSqliteDB.rawQuery(
                "SELECT * from location_data_insert_sale_table where dis_id='"
                        + dis_code + "'", null);
        if (cur != null) {
            if (cur.moveToFirst()) {
                do {
                    Map<String, String> locationMap = new HashMap<String, String>();
                    String loc_code = cur.getString(cur
                            .getColumnIndex("l_code"));
                    String loc_name = cur.getString(cur
                            .getColumnIndex("l_name"));
                    locationMap.put(loc_name, loc_code);
                    locationList.add(locationMap);
                } while (cur.moveToNext());
            }
        }
        return locationList;

    }

    public Cursor getLocationNotSelected(String dis_code) {
        Cursor cur = objSqliteDB.rawQuery(
                "SELECT * from location_data_insert_sale_table where dis_id='"
                        + dis_code + "'", null);
        return cur;
    }

    public int getMtp_id() {
        Cursor cur = objSqliteDB
                .rawQuery(
                        "Select Root_plan_id from root_plan order by Root_plan_id DESC limit 0,1",
                        null);

        int max_id = 0;
        if (cur != null) {
            if (cur.moveToFirst()) {
                do {
                    max_id = cur.getInt(cur.getColumnIndex("Root_plan_id"));
                } while (cur.moveToNext());
            }
        }
        return max_id;
    }


    public int dataExist(String date) {

        Cursor cur = objSqliteDB.rawQuery(
                "Select Root_plan_id from root_plan where date='" + date + "'",
                null);

        int max_id = 0;
        if (cur != null) {
            if (cur.moveToFirst()) {
                do {

                    max_id = cur.getInt(cur.getColumnIndex("Root_plan_id"));
                } while (cur.moveToNext());
            }
        }
        return max_id;
    }

    public Cursor getRootPlan1(int pos) {

        Cursor cursor;
        String gift = ("SELECT * from Root_Plan where delete_status=0 AND Root_plan_id=" + pos);
        cursor = objSqliteDB.rawQuery(gift, null);

        return cursor;
    }

    public Cursor select_Root_Plan() {
        String[] columns = new String[]{"_id", DataBaseManipulate.date_s,
                DataBaseManipulate.distributor_s, DataBaseManipulate.beat_s,
                DataBaseManipulate.pc};
        Cursor c = objSqliteDB.query(viewRootPlan, columns, "delete_status is not null or delete_status = ?",
                new String[]{"0"}, null, null, null);
        return c;
    }

    // For MTP Report
    public Cursor getRootPlanbydate(String date) {
        Cursor cursor;
        String gift = ("SELECT * from planned_datetable where  date='" + date + "'");
        cursor = objSqliteDB.rawQuery(gift, null);
        return cursor;
    }

    public Cursor getRootPlanbydateActual(String date) {
        Cursor cursor;
        String gift = ("SELECT * from actual_datetable where  date='" + date + "'");
        cursor = objSqliteDB.rawQuery(gift, null);
        return cursor;
    }

    public Cursor getPlanned() {
        Cursor cur = objSqliteDB.rawQuery("SELECT " + planned_report_table_id
                + " as _id, " + planned_report_table_date + ","
                + planned_report_table_dealer + "  from "
                + planned_report_table, new String[]{});
        return cur;
    }

    public Cursor getActual() {
        Cursor cur = objSqliteDB.rawQuery("SELECT " + actual_report_dealer_id
                + " as _id, " + actual_report_table_date + " from "
                + actual_report_table, new String[]{});
        return cur;
    }

    // Notification
//	public Cursor getNotification() {
//
//		String p_query = "select * from " + SYNC_NOTIFICATION
//				+ " where delete_status=0";
//		Cursor cursor = objSqliteDB.rawQuery(p_query, null);
//		return cursor;
//	}

    /*public Cursor getNotification() {

        String p_query = "select * from notification";

        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }*/

    // Notification
    public Cursor getNotification() {

        String p_query = "select * from " + SYNC_NOTIFICATION
                + " where delete_status=0";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);
        return cursor;
    }

    public Cursor getComplaintNotification() {

        String p_query = "select * from " + SYNC_Complaint_Redressel
                + " where delete_status=0";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);
        return cursor;
    }

    public Cursor getNotificationtocheck() {

        String p_query = "select * from " + SYNC_NOTIFICATION + "";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }

    public Cursor setSerialNumber() {

        String p_query = "select id from " + SYNC_NOTIFICATION + "";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }

    //Setting Notification Limit to 10 in showing Notification in inbox:-
    public Cursor getNotificationtocheck2() {

        String p_query = "select * from " + SYNC_NOTIFICATION + " order by id DESC Limit 10";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }

    //Setting Notification not read Limit to 10 in showing on icon:-
    public int getNotificationtocheck23() {

        String p_query = "select * from " + SYNC_NOTIFICATION + " where flag=0 order by id DESC";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);
        int qwe = cursor.getCount();
        cursor.close();
        return qwe;
    }

    public Cursor getReadNotification() {

        String p_query = "select * from " + SYNC_NOTIFICATION + " order by id DESC Limit 10";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }


    //GetAllData From Retailer Table:-
    public Cursor getAllDataFromRetailerTable(String c_code) {
        String retailer_query = "select * from retailer_data_insert where c_code='"
                + c_code + "'";
        Cursor cursor = objSqliteDB.rawQuery(retailer_query, null);

        return cursor;
    }

    /*// for payment collection
    public long payment_collection2(String dcode, String lcode, String rcode,
                                    String paymode, String amount2, String bbranch2,
                                    String chequenumber, String chequedate, String transactionno,
                                    String transactiondate, String c_date, String time, String imei) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseManipulate.dealercode2, dcode);
        cv.put(DataBaseManipulate.locationcode2, lcode);
        cv.put(DataBaseManipulate.retailercode2, rcode);
        cv.put(DataBaseManipulate.paymode2, paymode);
        cv.put(DataBaseManipulate.amount2, amount2);
        cv.put(DataBaseManipulate.bbranch2, bbranch2);
        cv.put(DataBaseManipulate.chequeno2, chequenumber);
        cv.put(DataBaseManipulate.chequedate2, chequedate);
        cv.put(DataBaseManipulate.transactionno2, transactionno);
        cv.put(DataBaseManipulate.transactiondate2, transactiondate);
        cv.put(DataBaseManipulate.date2, c_date);
        cv.put(DataBaseManipulate.time2, time);
        cv.put(DataBaseManipulate.imei2, imei);

        long coun2 = objSqliteDB.insert(
                DataBaseManipulate.Payment_Collection_Data_t, null, cv);
        return coun2;
    }*/


    public long payment_collection3(String dcode, String lcode, String rcode,
                                    String paymode, String amount2, String bbranch2,
                                    String chequenumber, String chequedate, String transactionno,
                                    String transactiondate, String c_date, String time, String imei) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseManipulate.dealercode3, dcode);
        cv.put(DataBaseManipulate.locationcode3, lcode);
        cv.put(DataBaseManipulate.retailercode3, rcode);
        cv.put(DataBaseManipulate.paymode3, paymode);
        cv.put(DataBaseManipulate.amount3, amount2);
        cv.put(DataBaseManipulate.bbranch3, bbranch2);
        cv.put(DataBaseManipulate.chequeno3, chequenumber);
        cv.put(DataBaseManipulate.chequedate3, chequedate);
        cv.put(DataBaseManipulate.transactionno3, transactionno);
        cv.put(DataBaseManipulate.transactiondate3, transactiondate);
        cv.put(DataBaseManipulate.date3, c_date);
        cv.put(DataBaseManipulate.time3, time);
        cv.put(DataBaseManipulate.imei3, imei);

        long coun2 = objSqliteDB.insert(
                DataBaseManipulate.Payment_Collection_Data_Distributor_t, null, cv);
        return coun2;
    }

    //Table For New Payment Collection:-
    public long new_payment_collection(String dcode, String lcode, String rcode,
                                       String paymode, String amount2, String bbranch2,
                                       String chequenumber, String chequedate, String transactionno,
                                       String transactiondate, String c_date, String time,
                                       String imei, String battery_status, String gps_status) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseManipulate.dealercode2, dcode);
        cv.put(DataBaseManipulate.locationcode2, lcode);
        cv.put(DataBaseManipulate.retailercode2, rcode);
        cv.put(DataBaseManipulate.paymode2, paymode);
        cv.put(DataBaseManipulate.amount2, amount2);
        cv.put(DataBaseManipulate.bbranch2, bbranch2);
        cv.put(DataBaseManipulate.chequeno2, chequenumber);
        cv.put(DataBaseManipulate.chequedate2, chequedate);
        cv.put(DataBaseManipulate.transactionno2, transactionno);
        cv.put(DataBaseManipulate.transactiondate2, transactiondate);
        cv.put(DataBaseManipulate.date2, c_date);
        cv.put(DataBaseManipulate.time2, time);
        cv.put(DataBaseManipulate.imei2, imei);
        cv.put(DataBaseManipulate.payment_battery_status, battery_status);
        cv.put(DataBaseManipulate.payment_gps_status, gps_status);

        long coun2 = objSqliteDB.insert(
                DataBaseManipulate.Payment_Collection_Data_t, null, cv);
        return coun2;
    }


    public Cursor getCustomerCount() {
        String p_query = "select * from retailer_data_insert";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }


    public Cursor getNotificationtocheck1() {

        String p_query = "select * from notification where delete_status=0";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;
    }
    // Plan VS Actual

    public Cursor getRootPlandetail(String date) {
        Cursor cursor;
        String quString = "select * from Root_Plan where date='" + date + "' ";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public String getTotalActualvalue(String date) {// changes
        String tootalvalue = "0";
        String qry = "select SUM(temp_pro_total_value) as totalsale  from "
                + SYNC_tempdatastore + " where temp_pro_current_date= '" + date
                + "' AND booked_order_type='true'";
        Cursor c = objSqliteDB.rawQuery(qry, null);
        if (c.moveToFirst()) {
            int index = c.getColumnIndex("totalsale");
            tootalvalue = c.getString(index);
        }
        return tootalvalue;
    }

    public String getDealerName(String getid) {
        String dealername = "No Name";
        String qry = "select DealerName  from  Dealer" + " where id= '" + getid
                + "'";
        Cursor c = objSqliteDB.rawQuery(qry, null);
        if (c.moveToFirst()) {
            int index = c.getColumnIndex("DealerName");
            dealername = c.getString(index);
        }
        return dealername;
    }

    public String getLocationName(String getid) {
        String locationname = "No Name";
        String qry = "select l_name  from  location_data_insert_sale_table "
                + " where l_code= '" + getid + "'";
        Cursor c = objSqliteDB.rawQuery(qry, null);
        if (c.moveToFirst()) {
            int index = c.getColumnIndex("l_name");
            locationname = c.getString(index);
        }
        return locationname;
    }

    // For Report under
    public Cursor get_user_reports() {
        Cursor cur = objSqliteDB.rawQuery("SELECT " + report_date + ", " + report_userid
                        + " as _id, " + report_username + ", " + report_totalcalls
                        + ", " + report_totalprodcalls + ", " + report_totalsalevalue
                        + ", " + report_user_beat_name + "  from " + report_userTable,
                new String[]{});
        return cur;
    }

    public String GetUserName(String ID) {
        String params = String.valueOf(ID);
        Cursor c = objSqliteDB
                .query(report_userTable, new String[]{
                                report_userTable_id + " as _id", report_username},
                        report_userid + "=?", new String[]{params}, null,
                        null, null);
        c.moveToFirst();
        int index = c.getColumnIndex(report_username);
        return c.getString(index);
    }

    public String GetUserLocation(String ID) {
        String params = String.valueOf(ID);
        Cursor c = objSqliteDB
                .query(report_userTable,
                        new String[]{report_userTable_id + " as _id",
                                report_user_beat_name}, report_userid + "=?",
                        new String[]{params}, null, null, null);
        c.moveToFirst();
        int index = c.getColumnIndex(report_user_beat_name);
        return c.getString(index);

    }

    public Cursor get_user_sku_reports() {
        /*Cursor cur = objSqliteDB.rawQuery("SELECT " + report_sku_userid
                + " as _id, " + report_sku_productname + ", "
				+ report_sku_quantity + ", " + report_sku_rate + ", "
				+ report_sku_totalsalerate + "  from " + report_sku_userTable,
				new String[] {});*/
        String str = ("SELECT " + report_sku_userid + " as _id, "
                + report_sku_productname + ", SUM(" + report_sku_quantity
                + ") as sku_user_quantity ," + "SUM(" + report_sku_totalsalerate
                + " )as sku_user_totalsalerate from " + report_sku_userTable
                + " GROUP BY " + report_sku_productname);
        Cursor cur = objSqliteDB.rawQuery(str, new String[]{});
        return cur;
    }

    // For Retailer Report
    public Cursor getAllSkuRetailerwise() {
        Cursor cur = objSqliteDB.rawQuery(
                "SELECT cat_id as _id, catname_retailerwise from "
                        + REPORT_RETAILER, new String[]{});
        return cur;
    }

    // For Daily Sales Report
    public long dsr_new_insert(String dis, String loc, int tot_call,
                               int tot_call_pro, String time, String rem, String c_date,
                               int daily_totalvalue, String latitude, String longitude,
                               String mcc_mnc_lac_cellId, String override) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseManipulate.distributor, dis);
        cv.put(DataBaseManipulate.location, loc);
        cv.put(DataBaseManipulate.daily_totel_call, tot_call);
        cv.put(DataBaseManipulate.daily_total_prod, tot_call_pro);
        cv.put(DataBaseManipulate.time, time);
        cv.put(DataBaseManipulate.remark, rem);
        cv.put(DataBaseManipulate.current_date, c_date);
        cv.put(DataBaseManipulate.daily_totalvalue, daily_totalvalue);
        cv.put(DataBaseManipulate.latitude, latitude);
        cv.put(DataBaseManipulate.longitude, longitude);
        cv.put(DataBaseManipulate.mcc_mnc_lac_cellId, mcc_mnc_lac_cellId);
        cv.put(DataBaseManipulate.override, override);
        long coun = objSqliteDB.insert(DataBaseManipulate.Daily_Sales_Report_t,
                null, cv);
        return coun;
    }

    // For AlarmReceiver Tracking
    public String getDebugStatus() {
        int debug;
        Cursor cursor;
        String quString = "select  debug_on from " + LOGIN_CONSTANT_DELETE + "";
        cursor = objSqliteDB.rawQuery(quString, null);
        cursor.moveToFirst();
        debug = cursor.getColumnIndex("debug_on");
        String debudstatus = cursor.getString(debug);
        return debudstatus;
    }

    public long track_location(String dat, String time, double lat, double lng,
                               String imei, String mcc_mnc_lac_cellId, String location) {
        this.track_statement.bindString(1, dat);
        this.track_statement.bindString(2, time);
        this.track_statement.bindDouble(3, lat);
        this.track_statement.bindDouble(4, lng);
        this.track_statement.bindString(5, imei);
        this.track_statement.bindString(6, mcc_mnc_lac_cellId);
        this.track_statement.bindString(7, location);
        return this.track_statement.executeInsert();
    }

    public Cursor check_tracking() {
        Cursor cursor;
        String quString = "select * from track_location where delete_status=0";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public Cursor getIdMini() {
        String p_query = "select id,t1 from " + LOGIN_TRACKINGTIME_MASTER
                + " where status=0 order by id ASC limit 0,1 ";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);
        return cursor;
    }

    public Cursor getLastLatLong(String date) {
        String p_query = "select lat,lng from " + SYNC_TRACKING_DETAILS
                + " where track_date='" + date + "' order by date ASC limit 0,1 ";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);
        return cursor;

    }

    public String getLastTrack() {
        String p_query = ("select t1 from trcking_time_master order by id DESC limit 1");
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);
        String track = "";
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    track = cursor.getString(cursor
                            .getColumnIndex("t1"));
                } while (cursor.moveToNext());
            }
        }
        return track;
    }


    public String getFirstTrack() {
        String p_query = ("select t1 from trcking_time_master order by id ");
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);
        String track = "";
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    track = cursor.getString(cursor
                            .getColumnIndex("t1"));
                } while (cursor.moveToNext());
            }
        }
        return track;
    }


    public int SelectId() {
        String p_query = "select id from " + LOGIN_TRACKINGTIME_MASTER
                + " where status=1 order by id DESC  limit 0,1";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);
        int max_id = 0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    max_id = cursor.getInt(cursor.getColumnIndex("id"));
                } while (cursor.moveToNext());
            }
        }
        return max_id;
    }


    public int deleteAllTracking() {
        return objSqliteDB.delete(SYNC_TRACKING_DETAILS, null, null);
    }

    public int getUserid() {
        int user_id = 0;
        Cursor cursor;
        String quString = "select  user_id from " + LOGIN_USERNAME_INSERT;
        cursor = objSqliteDB.rawQuery(quString, null);
        cursor.moveToFirst();
        user_id = cursor.getColumnIndex("user_id");
        int id = cursor.getInt(user_id);
        return id;
    }

    public Cursor getuserdetails() {
        Cursor cursor;
        objSqliteDB = objDataBaseHelper.getReadableDatabase();
        String qustr = "SELECT * from " + LOGIN_USERNAME_INSERT;
        cursor = objSqliteDB.rawQuery(qustr, null);
        return cursor;

    }

    // For Primary Sale
    public Cursor checkPreviousprimaryproduct(String grpID_childId,
                                              String order_id) {
        Cursor cursor;
        String qry = ("SELECT * from Primary_Sale  where primary_grpId_childId='"
                + grpID_childId + "' AND primary_order_id ='" + order_id + "'");
        cursor = objSqliteDB.rawQuery(qry, null);
        return cursor;
    }

    public Cursor checkPreviousrRetailerStockproduct(String grpID_childId,
                                                     String order_id) {
        Cursor cursor;
        String qry = ("SELECT * from retailerbalancestock  where retailer_grpId_childId='"
                + grpID_childId + "' AND retailer_order_id ='" + order_id + "'");
        cursor = objSqliteDB.rawQuery(qry, null);
        return cursor;
    }

    public void previousdatadelete(String grpID_childId, String orderid) {
        String str = ("DELETE from Primary_Sale WHERE primary_grpId_childId='"
                + grpID_childId + "' AND primary_order_id='" + orderid + "'");
        objSqliteDB.execSQL(str);
    }

    public int checkuserfillanyPrimarySaleproduct(String orderid) {
        Cursor cursor;
        String query_str = "select * from Primary_Sale where primary_order_id='"
                + orderid + "'";
        cursor = objSqliteDB.rawQuery(query_str, null);
        int count = cursor.getCount();
        return count;
    }

    public int checkuserfillanyRetailerproduct(String orderid) {
        Cursor cursor;
        String query_str = "select * from retailerbalancestock where retailer_order_id='"
                + orderid + "'";
        cursor = objSqliteDB.rawQuery(query_str, null);
        int count = cursor.getCount();
        return count;
    }

    public int deleteNonbookedPrimarySaleOrder(String tablename,
                                               String orderid, String status) {
        return objSqliteDB.delete(tablename, "primary_order_id='" + orderid
                + "' AND primary_order_status ='" + status + "'", null);
    }

    public int deletePrimarySaleOrder(String tablename, String orderid) {
        return objSqliteDB.delete(tablename, "primary_order_id='" + orderid + "'", null);
    }

    public int deleteSaleOrder(String tableName, String orderId, String status) {
        return objSqliteDB.delete(tableName, temp_pro_order_id + "='" + orderId + "' And " + temp_pro_booked_order_type + "='" + status + "'", null);
    }

    public int deleteSaleOrder1(String tableName, String orderId) {
        return objSqliteDB.delete(tableName, temp_pro_order_id + "='" + orderId + "'", null);
    }

    // ///////////// Balance Stock Methods/////////////////////////////

    public Cursor checkChildViewProduct(String balance_grpID_childId,
                                        String order_id) {
        Cursor cursor;
        String qry = "SELECT * from Balance_Stock  WHERE balance_grpID_childId='"
                + balance_grpID_childId
                + "' AND balance_order_id='"
                + order_id
                + "'";
        cursor = objSqliteDB.rawQuery(qry, null);
        return cursor;
    }

    public Cursor checkPreviousBalanceStockproduct(
            String balance_grpID_childId, String order_id) {
        Cursor cursor;
        String qry = "SELECT * from Balance_Stock  WHERE balance_grpID_childId='"
                + balance_grpID_childId
                + "' AND balance_order_id='"
                + order_id
                + "'";
        cursor = objSqliteDB.rawQuery(qry, null);
        return cursor;
    }

    public void previousBalanceStockdatadelete(String balance_grpID_childId,
                                               String orderid) {
        String str = ("DELETE from Balance_Stock WHERE balance_grpID_childId ='"
                + balance_grpID_childId + "' AND balance_order_id='" + orderid + "'");
        objSqliteDB.execSQL(str);
    }

    public int deleteBalnckStock_ChildData(String tablename, String orderid,
                                           String status, String balance_grpID_childId) {
        return objSqliteDB
                .delete(tablename,
                        "balance_order_id =?  AND balance_remove_unique_id =? AND balance_grpID_childId =?",
                        new String[]{orderid, status, balance_grpID_childId});
    }

    public int checkuserfillanyBalanckStockproduct(String orderid) {
        Cursor cursor;
        String query_str = "select * from Balance_Stock where balance_order_id='"
                + orderid + "'";
        cursor = objSqliteDB.rawQuery(query_str, null);
        int count = cursor.getCount();
        return count;
    }

    public int deleteNonbookedBalanceStockOrder(String tablename,
                                                String orderid, String status) {
        return objSqliteDB.delete(tablename,
                "balance_order_id =?  AND balance_order_status =?",
                new String[]{orderid, status});
    }

    public Cursor getBalanceStockProductTotalQty(String p_id) {
        String query_str = "select balance_total_value from Balance_Stock where balance_product_code_='"
                + p_id + "'";
        return objSqliteDB.rawQuery(query_str, null);
    }

    public Cursor get_Stock_value(String current_orderid) {
        String quString = "select * from " + SYNC_tempdatastore
                + " where temp_pro_order_id='" + current_orderid + "'";
        return objSqliteDB.rawQuery(quString, null);
    }

    public Cursor get_Stock_value1(String current_orderid) {
        String quString = "select * from " + SYNC_tempdatastore
                + " where temp_pro_order_id='" + current_orderid + "'";
        return objSqliteDB.rawQuery(quString, null);
    }


    public Cursor sync_daily_report(String tablename) {
        String quString = "select * from " + tablename
                + " where daily_status='0'";

        return objSqliteDB.rawQuery(quString, null);

    }

    public Cursor sync_get_attendence(String tablename) {
        String quString = "select * from " + tablename
                + " where delete_status='0'";
        return objSqliteDB.rawQuery(quString, null);
    }
    // ///////////// Balance Stock Methods Close ///////////////v//////////////

    // ////////////Login Competitor Methods /////////////////////////////

    public Cursor getCompetitors() {
        String str = ("Select compititor_id as _id,compititor_name from " + LOGIN_COMPETITIOR);
        Cursor cur = objSqliteDB.rawQuery(str, null);
        return cur;
    }

    public void deleteCompititor() {
        objSqliteDB.delete(LOGIN_COMPETITIOR, null, null);
    }

    // /////// Geo Fancing //////////////////

    public int deleteAllGeoFancingTableData() {
        return objSqliteDB.delete(GEO_FANCING_TABLE, null, null);
    }

    public Cursor getLatLongOfAllDealer_AND_Retailer() {
        Cursor cursor;
        String quString = "select * from geo_fancing_table ";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public Cursor getLatLongOfAllretailer() {
        Cursor cursor;
        String quString = "select * from tempdatastore ";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public int checkId_inGeoTableforstatuswise(String _id, String status) {
        Cursor cur = null;
        String query = "select * from geofancing_timedetails_table where dealer_and_retailer_id='"
                + _id + "' AND status='" + status + "'";
        cur = objSqliteDB.rawQuery(query, null);
        return cur.getCount();
    }

    public int checkId_inTforstatuswise(String _id) {
        Cursor cur = null;
        String query = "select * from tempdatastore where retailer_id='"
                + _id + "'";
        cur = objSqliteDB.rawQuery(query, null);
        return cur.getCount();
    }

    public Cursor check_geoFancing_data() {
        Cursor cursor;
        String quString = "select * from " + GEOFANCING_TIME_DATAILS_TABLE
                + " where delete_status=0 AND status=2";
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;

    }

    public Cursor checkPreviousDateRecord(String retailer_id, String Date) {
        Cursor cursor;

        String Query_data = "select temp_pro_order_id from tempdatastore where temp_pro_retailerid='"
                + retailer_id + "' AND temp_pro_current_date='" + Date + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public int checkRetailerLat_Long(String _id) {
        Cursor cur = null;
        String str_query = "select * from geo_fancing_table where dealer_and_retailer_id='"
                + _id + "'";
        cur = objSqliteDB.rawQuery(str_query, null);
        return cur.getCount();

    }

    public int checkRetailerLat_Long11(String _id) {
        Cursor cur = null;
        String str_query = "select * from tempdatastore where temp_pro_retailer_id='"
                + _id + "'";
        cur = objSqliteDB.rawQuery(str_query, null);
        return cur.getCount();

    }


    public Cursor checkPreviousRecordDate(String retailer_id) {
        Cursor cursor;

        String Query_data = "select Distinct (temp_pro_current_date) from tempdatastore where temp_pro_retailerid='"
                + retailer_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor getRetailerBeat_and_name(String retailer_id) {
        String Query_data1 = "select c_name, l_id  from retailer_data_insert where c_code='"
                + retailer_id + "'";
        return objSqliteDB.rawQuery(Query_data1, null);
    }

    public String getDealer_id(String location) {
        Cursor cur;
        String d_id = "";
        String Query_data1 = "select dis_id from location_data_insert_sale_table where l_code='"
                + location + "'";
        cur = objSqliteDB.rawQuery(Query_data1, null);
        if (cur.getCount() > 0) {
            if (cur.moveToFirst()) {
                do {
                    d_id = cur.getString(cur.getColumnIndex("dis_id"));
                } while (cur.moveToNext());
            }

        }
        return d_id;
    }

    // for Mtp And Selling

    public Cursor checkCurrentDayOrder(String r_id, String date) {
        String query_str = "select * from tempdatastore where temp_pro_retailerid='"
                + r_id + "' AND temp_pro_current_date='" + date + "'";
        return objSqliteDB.rawQuery(query_str, null);
    }

    public Cursor getRetailerIdOFCurrentDayBookedOrder(String date) {
        String query_str = "select * from tempdatastore where temp_pro_current_date='"
                + date + "'";
        return objSqliteDB.rawQuery(query_str, null);
    }

    // For CHECKING CURRENT DAY MTP
    public Cursor checkCurrentDayMtp(String date) {
        String query_str = "select * from Root_Plan where date='" + date + "'";
        return objSqliteDB.rawQuery(query_str, null);
    }

    // For Setting Focus Target in Focus Product:-
    public static Cursor focusTargetSet() {
        String query = "select focus_target from Product_table where ";
        Cursor cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

    public String getTotalCalls(String l_name) {
        Cursor cursor;
        String count = "";
        String Query_data1 = "select COUNT(DISTINCT c_name) as cname  from retailer_data_insert where l_id='"
                + l_name + "'";

        cursor = objSqliteDB.rawQuery(Query_data1, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    count = cursor.getString(cursor.getColumnIndex("cname"));
                    System.out.println("count----" + count);

                } while (cursor.moveToNext());
            }
        } else {
            count = "0";
        }
        return count;
    }

    // ///////////// Damage Product ACtivity
    // Methods/////////////////////////////

    public Cursor checkPreviousDamageProduct(String damage_grpID_childId,
                                             String order_id) {
        Cursor cursor;
        String qry = "SELECT * from Damage_Product  WHERE damage_grpID_childId='"
                + damage_grpID_childId
                + "' AND damage_order_id='"
                + order_id
                + "'";
        cursor = objSqliteDB.rawQuery(qry, null);
        return cursor;
    }

    public void previousDamageProductdelete(String damage_grpID_childId,
                                            String orderid) {
        String str = ("DELETE from Damage_Product WHERE damage_grpID_childId ='"
                + damage_grpID_childId + "' AND damage_order_id='" + orderid + "'");
        objSqliteDB.execSQL(str);
    }

    public int DeleteSalesHeadNotifi() {

        return objSqliteDB.delete(SalesHeadNotifiTable, null, null);

    }

    public int checkuserfillanyDamageProduct(String orderid) {
        Cursor cursor;
        String query_str = "select * from Damage_Product where damage_order_id='"
                + orderid + "'";
        cursor = objSqliteDB.rawQuery(query_str, null);
        int count = cursor.getCount();
        return count;
    }

    //anup
    public Cursor getTempmonth(String fromDate, String toDate) {
        Cursor cursor;


        String quString = "SELECT DISTINCT(temp_pro_current_date),SUM(temp_pro_total_value) as sale_value FROM tempdatastore GROUP BY temp_pro_current_date";

        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public int deleteNonbookedDamageProduct(String tablename, String orderid,
                                            String status) {
        return objSqliteDB.delete(tablename,
                "damage_order_id =?  AND damage_order_status =?", new String[]{
                        orderid, status});
    }

    public int deleteBalanceStock(String tablename, String orderid, String status) {
        return objSqliteDB.delete(tablename, " balance_order_id='" + orderid + "'", null);
    }

    public int getOrderCount(String tableName, String orderId, String orderIdCol) {
        int count = 0;
        try {
            objSqliteDB = objDataBaseHelper.getReadableDatabase();
            String gift = ("SELECT * from " + tableName + " where delete_status='0' AND " + orderIdCol + "= '" + orderId + "'");
            Cursor cursor = objSqliteDB.rawQuery(gift, null);

            count = (int) cursor.getCount();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public int deletePrimarySale(String tablename, String orderid, String status) {
        return objSqliteDB.delete(tablename, " primary_order_id='" + orderid + "'", null);
    }

    public Cursor getRootPlan1(String date) {

        objSqliteDB = objDataBaseHelper.getReadableDatabase();
        Cursor cursor;
        String gift = ("SELECT Root_plan_id from Root_Plan where delete_status=0 AND date= '"
                + date + "'");
        cursor = objSqliteDB.rawQuery(gift, null);

        return cursor;
    }

    public Cursor checkforsyncupdate() {

        objSqliteDB = objDataBaseHelper.getReadableDatabase();
        Cursor cursor5;
        String cheksync = ("SELECT * from check_for_update_data where update__data_status=1");
        cursor5 = objSqliteDB.rawQuery(cheksync, null);
        return cursor5;

    }

    public Cursor getUserInformationmtp112(String date, String todate) {

        Cursor cursor;
        String quString = "select  * from mtpdata where date BETWEEN '" + date + "' AND '" + todate + "'ORDER BY date DESC LIMIT 3";


        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    public Cursor getUserInformationmtpNew(String date) {

        Cursor cursor;
        String quString = "select * from mtpdata where date = '" + date + "'";

        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    //Getting Focus Target for Focus Product:-
    public Cursor getFocusTarget() {

        Cursor cursor;
        String quString = "select focus_target from Product_table";

        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    //Getting Focus Target for Focus Product:-
    public Cursor getFocusAcheivedValue(String date) {

        Cursor cursor;
        String quString = "select SUM(temp_pro_total_value) as temp_pro_total_value12 from tempdatastore where temp_pro_focus='1' AND temp_pro_current_date='" + date + "'";

        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    public Cursor getTemp112(String date, String todate) {

        Cursor cursor;
        String quString = "SELECT  temp_pro_current_date,SUM(temp_pro_total_value) as sale_value FROM tempdatastore where temp_pro_current_date BETWEEN '" + date + "' AND '" + todate + "' GROUP BY temp_pro_current_date ORDER BY temp_pro_current_date DESC LIMIT 0,3";
//SELECT temp_pro_current_date,SUM(temp_pro_total_value) as sale_value FROM tempdatastore where temp_pro_current_date= '"+fromDate +"'GROUP BY temp_pro_current_date


        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    public long insertStatusOfSyncData() {
        objSqliteDB = objDataBaseHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("update__data_status", 1);
        return objSqliteDB.insert(CHECK_FOR_UPDATE_DATA, null, cv);
    }

    public long deleteStatusOfSyncData() {
        objSqliteDB = objDataBaseHelper.getReadableDatabase();
        return (long) objSqliteDB.delete(CHECK_FOR_UPDATE_DATA, null, null);
    }

    // ///////////// Damage Product Activity Close/////////////////////////////

    // ////////// Check Attendance Enable -Disable Query ////////////
    public Cursor getSubjectId() {
        objSqliteDB = objDataBaseHelper.getReadableDatabase();
        Cursor cursor;
        String query = "select * from " + TAKE_STUDENT_ATTENDANCE + " where sub_id ";
        return objSqliteDB.rawQuery(query, null);

    }


    public int checkAttendanceTableCount(String current_Date, String Strpaper,
                                         String Strsubject, String Strsemeste,
                                         String Strclasstype, String Strsection) {
        objSqliteDB = objDataBaseHelper.getReadableDatabase();
        Cursor cursor;
        String query = ("SELECT * from " + TAKE_STUDENT_ATTENDANCE + " where attendence_date ='" + current_Date
                + "' and sub_id=" + Strsubject + " and semester_id=" + Strsemeste + " and class_type_id=" + Strclasstype
                + " and section_id=" + Strsection);
        cursor = objSqliteDB.rawQuery(query, null);
        return cursor.getCount();
    }

    public Cursor getDateCount(String date) {
        String str = ("Select * from " + ATTENDANCE_STORETABEL
                + " Where attn_date='" + date + "'");
        return objSqliteDB.rawQuery(str, null);
    }

    public Cursor getdatecheckcount(String date) {
        String str = ("Select * from " + SYNC_CHECKOUT_TABLE
                + " Where date='" + date + "'");
        return objSqliteDB.rawQuery(str, null);
    }


    public int checkforcheckout(String date) {
        Cursor cursor;
        String quString = "select * from " + SYNC_CHECKOUT_TABLE + " where date='"
                + date + "'";
        cursor = objSqliteDB.rawQuery(quString, null);

        int count = cursor.getCount();

        return count;
    }

    public int checkforAttandance(String date) {
        Cursor cursor;
        String quString = "select * from " + ATTENDANCE_STORETABEL + " where attn_date='"
                + date + "'";
        cursor = objSqliteDB.rawQuery(quString, null);

        int count = cursor.getCount();

        return count;
    }


    public Cursor check_attendance(String date) {

        Cursor cursor;
        String quString = "select * from attendance_store_table where attn_date='"
                + date + "'";
        cursor = objSqliteDB.rawQuery(quString, null);

        int count = cursor.getCount();

        return cursor;
    }

    public int getcount(String tablename) {
        String quString = "select * from " + tablename
                + " where daily_status=0";

        Cursor cursor = objSqliteDB.rawQuery(quString, null);

        return cursor.getCount();

    }

    public int getcount1(String tablename) {
        String quString = "select * from " + tablename
                + " where daily_status=0";

        Cursor cursor = objSqliteDB.rawQuery(quString, null);
        return cursor.getCount();

    }

    public Cursor getuserpass() {
        Cursor cursor;
        String quString = "select * from " + LOGIN_USERNAME_INSERT;
        cursor = objSqliteDB.rawQuery(quString, null);
        return cursor;
    }

    public int insertSurveyQuestions(String Q_ID, String Q_TYPE, String Q_NAME) {
        ContentValues values = new ContentValues();
        values.put(QuestionId, Q_ID);
        values.put(QuestionType, Q_TYPE);
        values.put(QuestionName, Q_NAME);

        // Inserting Row
        long insertCheck = objSqliteDB.insert(EssQuestionSurvey, null, values);
        return (int) insertCheck;
    }

    public int insertSurveyQuestionsType(String Q_TYPE_ID, String Q_TYPE_NAME) {
        ContentValues values = new ContentValues();
        values.put(QuestionTypeId, Q_TYPE_ID);
        values.put(QuestionTypeName, Q_TYPE_NAME);

        // Inserting Row
        long insertCheck = objSqliteDB.insert(EssQuestionType, null, values);
        return (int) insertCheck;
    }

    public int insertReportingManagerFields(String seniorName, String roleNAme) {
        ContentValues values = new ContentValues();
        values.put(SeniorName, seniorName);
        values.put(RoleName, roleNAme);

        // Inserting Row
        long insertCheck = objSqliteDB.insert("reportingManagerTable", null, values);
        return (int) insertCheck;
    }

    public int insertSurveyQuestionOptions(String optionID, String shortName, String description) {
        ContentValues values = new ContentValues();
        values.put(QuestionOptionID, optionID);
        values.put(QuestionOptionShortName, shortName);
        values.put(QuestionOptionDescription, description);

        // Inserting Row
        long insertCheck = objSqliteDB.insert(EssQuestionOption, null, values);
        return (int) insertCheck;
    }

    public Cursor getSurveyQuestion() {
        String str = ("Select * from " + EssQuestionSurvey);
        Cursor cur = objSqliteDB.rawQuery(str, null);
        return cur;
    }


    public Cursor getQuestionTypeName(String q_id) {
        String str = ("select questionTypeName from EssQuestionTypeTable where questionTypeId='"
                + q_id + "'");
        Cursor cur = objSqliteDB.rawQuery(str, null);
        return cur;
    }

    public Cursor getQuestionType() {
        String str = ("Select * from " + EssQuestionType);
        Cursor cur = objSqliteDB.rawQuery(str, null);
        return cur;
    }

    public Cursor getQuestionOption() {
        String str = ("Select * from " + EssQuestionOption);
        Cursor cur = objSqliteDB.rawQuery(str, null);
        return cur;
    }

    public ArrayList<HashMap<String, String>> getESSAllQuestion(String date) {
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String, String> map;
        Cursor mCursor = objSqliteDB.query(EssQuestionGetting,
                new String[]{Question_Id, Option_Id, Question_Type_Id},
                Current_Date1 + "='" + date + "'", null, null, null, null);

        if (mCursor.getCount() > 0) {
            mCursor.moveToFirst();
            do {
                String Q_ID = mCursor.getString(mCursor.getColumnIndex(Question_Id));
                String Q_TYPE_ID = mCursor.getString(mCursor.getColumnIndex(Question_Type_Id));
                String option_ID = mCursor.getString(mCursor.getColumnIndex(Option_Id));

                map = new HashMap<>();
                map.put("Q_ID", Q_ID);
                map.put("Q_TYPE_ID", Q_TYPE_ID);
                map.put("option_ID", option_ID);
                list.add(map);
            } while (mCursor.moveToNext());
        }
        mCursor.close();
        return list;
    }


    //Notification Delete Query:-
    public int deleteNotification(String id) {
        return objSqliteDB.delete(SYNC_NOTIFICATION, "id" + "=?",
                new String[]{id});
    }

    //Getting All Data for Hod , Employee , Suggestion :-
    public Cursor getAllDataForHod(String date) {
        String query = "select * from EssAllDataTable where current_Date='" + date + "'";
        Cursor cursor = objSqliteDB.rawQuery(query, null);
        return cursor;

    }

    //Getting All Data for Hod , Employee , Suggestion :-
    public Cursor getAllDataForSuggestion(String date) {
        String query = "select * from SuggestionGettingTable where current_Date='" + date + "'";
        Cursor cursor = objSqliteDB.rawQuery(query, null);
        return cursor;

    }

    //Getting All Data for Hod , Employee , Suggestion :-
    public Cursor getAllDataForEmployee(String date) {
        String query = "select * from EmployeeDataGettingTable where current_Date='" + date + "'";
        Cursor cursor = objSqliteDB.rawQuery(query, null);
        return cursor;

    }


    //Getting All Data for Review Question :-
    public Cursor getAllDataForReviewQuestion(String date) {
        String query = "select * from EssQuestionGettingTable where current_Date='" + date + "'";
        Cursor cursor = objSqliteDB.rawQuery(query, null);
        return cursor;

    }

    //Insert Method For Recommended SKU Table:-
    public Cursor getAllDataForRecommendedSKU(String date) {
        String query = "select quantity from RecommendedSKU where fromDate>='" + date + "'<=toDate";
        Cursor cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

    public Cursor getDateForEmployeeAutoFill() {
        String query = "select person_name,personrole from constants_flag";
        Cursor cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }


    public String getCallDetailForSaleDetail(String current_date) {

        String count = "";
        String query = "select Count(Distinct temp_pro_retailerid)  as count  from tempdatastore where temp_pro_current_date='" + current_date + "'";

        Cursor cursor = objSqliteDB.rawQuery(query, null);

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    count = cursor.getString(cursor.getColumnIndex("count"));
                    System.out.println("count----" + count);

                } while (cursor.moveToNext());
            }
        } else {
            count = "0";
        }

        return count;

    }

    public String getProductiveCallDetailForSaleDetail(String current_date) {
        String count = "";
        String query = "select Count(Distinct temp_pro_retailerid)  as count from tempdatastore where booked_order_type='true' and temp_pro_current_date='" + current_date + "'";

        Cursor cursor = objSqliteDB.rawQuery(query, null);


        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    count = cursor.getString(cursor.getColumnIndex("count"));
                    System.out.println("count----" + count);

                } while (cursor.moveToNext());
            }
        } else {
            count = "0";
        }

        return count;

    }

    public Cursor getTotalSaleDetail(String current_date) {
        String query = "select *,sum(temp_pro_total_value) as total_sale_value from tempdatastore where booked_order_type='true' and temp_pro_current_date='" + current_date + "'";

        Cursor cursor = objSqliteDB.rawQuery(query, null);


        return cursor;

    }

    public String getRoleNameForEmployee(String role) {
        String role1 = "";
        String p_query = "select role  from role_table1 where r_id='" + role + "'";
        Cursor cursor1 = objSqliteDB.rawQuery(p_query, null);

        if (cursor1 != null) {
            if (cursor1.moveToFirst()) {
                do {
                    role1 = cursor1.getString(cursor1.getColumnIndex("role"));
                } while (cursor1.moveToNext());
            }
        }
        return role1;
    }

    public boolean isEnableRoleWiseMenu(String role_id) {
        boolean isEnable = false;
        String p_query = "select r_id  from role_table1 where r_id='" + role_id + "'";
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                isEnable = true;
            }
        }
        return isEnable;
    }

    public List<String> getAllTownNameList() {
        List<String> list = new ArrayList<>();

        Cursor cursor;
        String query = "select * from " + userTown;

        cursor = objSqliteDB.rawQuery(query, null);

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String townName = cursor.getString(cursor.getColumnIndex("userTownName"));
                    list.add(townName);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    public List<String> getAllTownNameListFilter(String like) {
        List<String> list = new ArrayList<>();

        Cursor cursor;
        String query = "select * from " + userTown + " Where userTownName like '%"
                + like
                + "%' order by userTownName";
        ;

        cursor = objSqliteDB.rawQuery(query, null);

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String townName = cursor.getString(cursor.getColumnIndex("userTownName"));
                    list.add(townName);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    public List<String> getAllTownNameListIdFilter(String like) {
        List<String> list = new ArrayList<>();

        Cursor cursor;
        String query = "select * from " + userTown + " Where userTownName like '%"
                + like
                + "%' order by userTownName";

        cursor = objSqliteDB.rawQuery(query, null);

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String id = cursor.getString(cursor.getColumnIndex("userTownId"));
                    list.add(id);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    public List<String> getAllTownNameListId() {
        List<String> list = new ArrayList<>();

        Cursor cursor;
        String query = "select * from " + userTown;

        cursor = objSqliteDB.rawQuery(query, null);

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String id = cursor.getString(cursor.getColumnIndex("userTownId"));
                    list.add(id);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    // Method's to get all state town of user
    public List<String> getAllUserStateTownNameList() {
        List<String> list = new ArrayList<>();

        Cursor cursor;
        String query = "select * from " + userTown;

        cursor = objSqliteDB.rawQuery(query, null);

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String townName = cursor.getString(cursor.getColumnIndex(DataBaseManipulate.userTownName));
                    list.add(townName);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    public List<String> getAllUserStateTownNameListFilter(String like) {
        List<String> list = new ArrayList<>();

        Cursor cursor;
        String query = "select * from " + userTown + " Where userTownName like '%"
                + like
                + "%' order by userTownName";

        cursor = objSqliteDB.rawQuery(query, null);

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String townName = cursor.getString(cursor.getColumnIndex(DataBaseManipulate.userTownName));
                    list.add(townName);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    public List<String> getAllUserStateTownNameListIdFilter(String like) {
        List<String> list = new ArrayList<>();

        Cursor cursor;
        String query = "select * from " + userTown + " Where userTownName like '%"
                + like
                + "%' order by userTownName";
        ;

        cursor = objSqliteDB.rawQuery(query, null);

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String id = cursor.getString(cursor.getColumnIndex(DataBaseManipulate.userTownId));
                    list.add(id);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    public List<String> getAllUserStateTownNameListId() {
        List<String> list = new ArrayList<>();

        Cursor cursor;
        String query = "select * from " + userTown;

        cursor = objSqliteDB.rawQuery(query, null);

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String id = cursor.getString(cursor.getColumnIndex(DataBaseManipulate.userTownId));
                    list.add(id);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }
    // End


    // Method's to get all colleague of user
    public List<String> getAllWorkingWithNameList() {
        List<String> list = new ArrayList<>();

        Cursor cursor;
        String query = "select * from " + userColleague;

        cursor = objSqliteDB.rawQuery(query, null);

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String townName = cursor.getString(cursor.getColumnIndex(DataBaseManipulate.userColleagueName));
                    list.add(townName);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }


    public List<String> getAllWorkingWithIdList() {
        List<String> list = new ArrayList<>();

        Cursor cursor;
        String query = "select * from " + userColleague;

        cursor = objSqliteDB.rawQuery(query, null);

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String id = cursor.getString(cursor.getColumnIndex(DataBaseManipulate.userColleagueId));
                    list.add(id);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }
    // End

    public String getName(String table, String column, String where_cls) {
        String name = "";
        Cursor cursor;
        String query = "select " + column + " from " + table + " " + where_cls;

        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    name = cursor.getString(cursor.getColumnIndex(column));

                } while (cursor.moveToNext());
            }
        }
        return name;

    }

    public List<String> getAllDealerName() {
        List<String> list = new ArrayList<>();
        Cursor cursor;
        String query = "select * from " + LOGIN_DEALER_TABLE;

        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String dealerName = cursor.getString(cursor.getColumnIndex("DealerName"));
                    list.add(dealerName);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    public List<String> getAllDealerIDs() {
        List<String> list = new ArrayList<>();
        Cursor cursor;
        String query = "select * from " + LOGIN_DEALER_TABLE;

        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String dealerID = cursor.getString(cursor.getColumnIndex("id"));
                    list.add(dealerID);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }


    public List<String> getAllBeatName(String dealer_id) {
        List<String> list = new ArrayList<>();
        Cursor cursor;
        String query = "select * from " + LOGIN_BEAT_TABLE + " where dis_id='" + dealer_id + "'";

        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String beatName = cursor.getString(cursor.getColumnIndex("b_name"));
                    list.add(beatName);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    public List<String> getAllBeatIDs(String dealer_id) {
        List<String> list = new ArrayList<>();
        Cursor cursor;
        String query = "select * from " + LOGIN_BEAT_TABLE + " where dis_id='" + dealer_id + "'";

        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String beatID = cursor.getString(cursor.getColumnIndex("b_code"));
                    list.add(beatID);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    public List<String> getAllRetailerName(String location_id) {
        List<String> list = new ArrayList<>();
        Cursor cursor;
        String query = "select * from " + LOGIN_RETAILER_TABLE + " where l_id='" + location_id + "'";

        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String retailerName = cursor.getString(cursor.getColumnIndex("c_name"));
                    list.add(retailerName);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    public List<String> getAllRetailerIDs(String location_id) {
        List<String> list = new ArrayList<>();
        Cursor cursor;
        String query = "select * from " + LOGIN_RETAILER_TABLE + " where l_id='" + location_id + "'";

        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String retailerID = cursor.getString(cursor.getColumnIndex("c_code"));
                    list.add(retailerID);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    public List<String> getAllPaymentMode() {
        List<String> list = new ArrayList<>();
        Cursor cursor;
        String query = "select * from " + LOGIN_PAYMENT_MODE;

        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String mode = cursor.getString(cursor.getColumnIndex("mode"));
                    list.add(mode);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    public List<String> getAllPaymentIds() {
        List<String> list = new ArrayList<>();
        Cursor cursor;
        String query = "select * from " + LOGIN_PAYMENT_MODE;

        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String payment_id = cursor.getString(cursor.getColumnIndex("payment_id"));
                    list.add(payment_id);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    //Getting All Login user Data:-
    public Cursor gettingAllUserData() {
        Cursor cursor;
        String query = "select * from " + LOGIN_CONSTANT_DELETE;

        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

    public Cursor getTownNameOnChangeDealer(String dealer_id) {
        Cursor cursor;
        String query = "select town_name , town_id from " + LOGIN_DEALER_TABLE + " where id ='" + dealer_id + "'";

        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

    public Cursor gettingPaymentReceivedModeData() {
        Cursor cursor;
        //String query = "select town_name , town_id from " + LOGIN_DEALER_TABLE ;
        String query = "select * from " + PAYMENT_RECEIVED_DETAILS;

        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

    public Cursor gettingPaymentReceivedRetailerModeData() {
        Cursor cursor;
        String query = "select * from " + PAYMENT_RECEIVED_RETAILER;

        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

    public List<String> getAllMtpDates() {
        List<String> list = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DataBaseManipulate.Root_plan_s;

        //   SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = objSqliteDB.rawQuery(selectQuery, null);//selectQuery,selectedArguments

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(cursor.getColumnIndex(DataBaseManipulate.date_s)));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public Cursor select_Event1() {
        String[] columns = new String[]{"Root_plan_id", "date"};
        Cursor c = objSqliteDB.query("Root_Plan", columns, "delete_status=?",
                new String[]{"0"}, null, null, null);
        return c;
    }


    public Cursor select_Event() {
        objSqliteDB = objDataBaseHelper.getReadableDatabase();
        Cursor cursor;
        String query = ("Select result.*, town_name_list.town_name as town_name from (SELECT Root_Plan.*, task_of_the_day.name from Root_Plan join task_of_the_day on task_of_the_day.task_id = Root_Plan.status) as result join town_name_list on town_name_list.town_id=result.town_id");
        cursor = objSqliteDB.rawQuery(query, null);

        return cursor;
    }

    public Cursor getEventsId(String date) {

        objSqliteDB = objDataBaseHelper.getReadableDatabase();
        Cursor cursor;
        String gift = ("SELECT Root_plan_id as id from Root_Plan where date= '"
                + date + "'");
        cursor = objSqliteDB.rawQuery(gift, null);

        return cursor;
    }

    public Cursor getAllEvents(int pos) {

        Cursor cursor;
        String event = ("SELECT * from Root_Plan where Root_plan_id=" + pos);
        cursor = objSqliteDB.rawQuery(event, null);

        return cursor;
    }

    // Get Retailer Comment

    public Cursor getRetailerComment() {
        Cursor cursor;
        String quString = "select * from " + comment_data + " where delete_status=0";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    // Save Complaint Report:-
    public int saveComplaintReport(String complaintProduct, String size, String natureOfComplaintMentioned,
                                   String quantityLying, String complaintWithRetailer, String casesWithComplaint,
                                   String casesRv, String packersSlip, String billNo, String date,
                                   String amountOfBill, String productDispatched, String manufacturingUnit,
                                   String sampleClosed, String concernedSuperDistributorAddress,
                                   String concernedRetailerAddress, String concernedConsumerAddress,
                                   String actionTaken, String comments, String curr_date, String curr_time,
                                   double latitude, double longitude, String geo_address, String mcc_mnc,
                                   String unique_id, String order_id, String user_id, String complaintByStr,
                                   String agreeStr, String complaintID, String agreeID,
                                   String battery_status, String gps_status) {
        ContentValues cv = new ContentValues();
        cv.put("complaintProduct", complaintProduct);
        cv.put("size", size);
        cv.put("natureOfComplaintMentioned", natureOfComplaintMentioned);
        cv.put("quantityLying", quantityLying);
        cv.put("complaintWithRetailer", complaintWithRetailer);
        cv.put("casesWithComplaint", casesWithComplaint);
        cv.put("casesRv", casesRv);
        cv.put("packersSlip", packersSlip);
        cv.put("billNo", billNo);
        cv.put("date", date);
        cv.put("amountOfBill", amountOfBill);
        cv.put("productDispatched", productDispatched);
        cv.put("manufacturingUnit", manufacturingUnit);
        cv.put("sampleClosed", sampleClosed);
        cv.put("concernedSuperDistributorAddress", concernedSuperDistributorAddress);
        cv.put("concernedRetailerAddress", concernedRetailerAddress);
        cv.put("concernedConsumerAddress", concernedConsumerAddress);
        cv.put("actionTaken", actionTaken);
        cv.put("comments", comments);
        cv.put("curr_date", curr_date);
        cv.put("curr_time", curr_time);
        cv.put("latitude", latitude);
        cv.put("longitude", longitude);
        cv.put("geo_address", geo_address);
        cv.put("mcc_mnc", mcc_mnc);
        cv.put("unique_id", unique_id);
        cv.put("order_id", order_id);
        cv.put("user_id", user_id);
        cv.put("complaintByStr", complaintByStr);
        cv.put("agreeStr", agreeStr);
        cv.put("complaintID", complaintID);
        cv.put("agreeID", agreeID);
        cv.put("battery_status", battery_status);
        cv.put("gps_status", gps_status);

        long check_status = objSqliteDB.insert(DataBaseManipulate.ComplaintReport, null, cv);

        return (int) check_status;
    }

    public List<String> getAllTravellingModeName() {
        List<String> list = new ArrayList<>();

        Cursor cursor;
        String query = "select * from " + DataBaseManipulate.TravellingMode_TABLE;

        cursor = objSqliteDB.rawQuery(query, null);

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String townName = cursor.getString(cursor.getColumnIndex(DataBaseManipulate.colTravellingModeName));
                    list.add(townName);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }


    public List<String> getAllTravellingModeID() {
        List<String> list = new ArrayList<>();

        Cursor cursor;
        String query = "select * from " + DataBaseManipulate.TravellingMode_TABLE;

        cursor = objSqliteDB.rawQuery(query, null);

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String id = cursor.getString(cursor.getColumnIndex(DataBaseManipulate.colTravellingModeId1));
                    list.add(id);
                } while (cursor.moveToNext());
            }
        }
        return list;
    }

    public int saveTravellingExpense(String travellingDate, String arrivalTime, String departureTime,
                                     String distance, String fare, String da, String hotel, String postage,
                                     String telephoneExpense, String conveyance, String misc, String total,
                                     String arrivalID, String departureID, String travelModeID, double latitude,
                                     double longitude, String geo_address, String currDate, String currTime,
                                     String mcc_mnc, String userID, String orderID, String uniqueID, String battery_status,
                                     String gps_status, String Oneimage,
                                     String twoimage, String threeimage) {

        ContentValues cv = new ContentValues();
        cv.put("travellingDate", travellingDate);
        cv.put("arrivalTime", arrivalTime);
        cv.put("departureTime", departureTime);
        cv.put("distance", distance);
        cv.put("fare", fare);
        cv.put("da", da);
        cv.put("hotel", hotel);
        cv.put("postage", postage);
        cv.put("telephoneExpense", telephoneExpense);
        cv.put("conveyance", conveyance);
        cv.put("misc", misc);
        cv.put("total", total);
        cv.put("arrivalID", arrivalID);
        cv.put("departureID", departureID);
        cv.put("travelModeID", travelModeID);
        cv.put("latitude", latitude);
        cv.put("longitude", longitude);
        cv.put("geo_address", geo_address);
        cv.put("mcc_mnc", mcc_mnc);
        cv.put("curr_date", currDate);
        cv.put("curr_time", currTime);
        cv.put("order_id", orderID);
        cv.put("unique_id", uniqueID);
        cv.put("user_id", userID);
        cv.put("battery_status", battery_status);
        cv.put("gps_status", gps_status);
        cv.put("Oneimage", Oneimage);
        cv.put("twoimage", twoimage);
        cv.put("threeimage", threeimage);
        long status = objSqliteDB.insert(DataBaseManipulate.TravellingExpenseBill, null, cv);
        return (int) status;

    }

    public int saveProductInvestigationReport(
            String brandProduct, String packSize, String productPurchasedFrom, String productPurchasedTown,
            String productPurchasedDistrict, String productPurchasedState, String productPurchasedPhone,
            String productPurchasedFax, String productPurchasedEmail, String otherEstimatedSales,
            String manufactureDetail, String manufactureTown, String manufactureDistrict, String manufactureState,
            String manufactureGodownPhone, String manufactureGodownMobile, String manufactureGodownFax,
            String manufactureGodownEmail, String manufactureOfficePhone, String manufactureOfficeMobile,
            String manufactureOfficeFax, String manufactureOfficeEmail, String manufactureGodownResidencePhone,
            String manufactureGodownResidenceMobile, String manufacturegodownResidenceFax,
            String manufactureGodownResidenceEmail, String detailsStockiest, String stockiestTown,
            String stockiestDistrict, String stockiestState, String stockiestGodownPhone,
            String stockiestGodownMobile, String stockiestGodownFax, String stockiestGodownEmail,
            String stockiestOfficePhone, String stockiestOfficeMobile, String stockiestOfficeFax,
            String stockiestOfficeEmail, String stockiestResidencePhone, String stockiestResidenceMobile,
            String stockiestResidenceFax, String stockiestResidenceEmail, String estimatedMonthlyTurnOver,
            String anyOtherComment, double latitude, double longitude, String geo_address, String mcc_mnc,
            String currDate, String currTime, String orderID, String uniqueID, String userID, String battery_status,
            String gps_status) {

        ContentValues cv = new ContentValues();
        cv.put("brandProduct", brandProduct);
        cv.put("packSize", packSize);
        cv.put("productPurchasedFrom", productPurchasedFrom);
        cv.put("productPurchasedTown", productPurchasedTown);
        cv.put("productPurchasedDistrict", productPurchasedDistrict);
        cv.put("productPurchasedState", productPurchasedState);
        cv.put("productPurchasedPhone", productPurchasedPhone);
        cv.put("productPurchasedFax", productPurchasedFax);
        cv.put("productPurchasedEmail", productPurchasedEmail);
        cv.put("otherEstimatedSales", otherEstimatedSales);
        cv.put("manufactureDetail", manufactureDetail);
        cv.put("manufactureTown", manufactureTown);
        cv.put("manufactureDistrict", manufactureDistrict);
        cv.put("manufactureState", manufactureState);
        cv.put("manufactureGodownPhone", manufactureGodownPhone);
        cv.put("manufactureGodownMobile", manufactureGodownMobile);
        cv.put("manufactureGodownFax", manufactureGodownFax);
        cv.put("manufactureGodownEmail", manufactureGodownEmail);
        cv.put("manufactureOfficePhone", manufactureOfficePhone);
        cv.put("manufactureOfficeMobile", manufactureOfficeMobile);
        cv.put("manufactureOfficeFax", manufactureOfficeFax);
        cv.put("manufactureOfficeEmail", manufactureOfficeEmail);
        cv.put("manufactureGodownResidencePhone", manufactureGodownResidencePhone);
        cv.put("manufactureGodownResidenceMobile", manufactureGodownResidenceMobile);
        cv.put("manufacturegodownResidenceFax", manufacturegodownResidenceFax);
        cv.put("manufactureGodownResidenceEmail", manufactureGodownResidenceEmail);
        cv.put("detailsStockiest", detailsStockiest);
        cv.put("stockiestTown", stockiestTown);
        cv.put("stockiestDistrict", stockiestDistrict);
        cv.put("stockiestState", stockiestState);
        cv.put("stockiestGodownPhone", stockiestGodownPhone);
        cv.put("stockiestGodownMobile", stockiestGodownMobile);
        cv.put("stockiestGodownFax", stockiestGodownFax);
        cv.put("stockiestGodownEmail", stockiestGodownEmail);
        cv.put("stockiestOfficePhone", stockiestOfficePhone);
        cv.put("stockiestOfficeMobile", stockiestOfficeMobile);
        cv.put("stockiestOfficeFax", stockiestOfficeFax);
        cv.put("stockiestOfficeEmail", stockiestOfficeEmail);
        cv.put("stockiestResidencePhone", stockiestResidencePhone);
        cv.put("stockiestResidenceMobile", stockiestResidenceMobile);
        cv.put("stockiestResidenceFax", stockiestResidenceFax);
        cv.put("stockiestResidenceEmail", stockiestResidenceEmail);
        cv.put("estimatedMonthlyTurnOver", estimatedMonthlyTurnOver);
        cv.put("anyOtherComment", anyOtherComment);
        cv.put("latitude", latitude);
        cv.put("longitude", longitude);
        cv.put("geo_address", geo_address);
        cv.put("mcc_mnc", mcc_mnc);
        cv.put("curr_date", currDate);
        cv.put("curr_time", currTime);
        cv.put("order_id", orderID);
        cv.put("unique_id", uniqueID);
        cv.put("user_id", userID);
        cv.put("battery_status", battery_status);
        cv.put("gps_status", gps_status);

        long check_status = objSqliteDB.insert(DataBaseManipulate.ProductInvestigationReport, null, cv);

        return (int) check_status;
    }

    public Cursor getMtpData() {
        Cursor cursor;
        String query = "select date from mtpdata ";
        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

    public Cursor getTargetAmount(String date) {
        Cursor cursor;
        String query = "select rd from mtpdata where date='" + date + "'";
        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

    public Cursor getAllUserEditData() {
        Cursor cursor;
        String query = "select * from " + DataBaseManipulate.LOGIN_CONSTANT_DELETE;
        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

    public Cursor getEditInformationDetail() {

        String p_query = "select * from " + DataBaseManipulate.LOGIN_CONSTANT_DELETE;
        Cursor cursor = objSqliteDB.rawQuery(p_query, null);

        return cursor;

    }

    public Cursor getWebViewStatus() {
        Cursor cursor;
        String query = "select * from " + LOGIN_CONSTANT_DELETE;
        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

    public Cursor getAllNavigateLatAndLng() {
        Cursor cursor;
        String query = "select * from " + LOGIN_RETAILER_TABLE;
        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

    public Cursor getTodayBeat(String currDate) {
        Cursor cursor;
        String query = "select beat from Root_Plan where date='" + currDate + "'";
        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }


    public Cursor getTodayBeat1() {
        Cursor cursor;
        String query = "select beat from Root_Plan where date";
        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

    public Cursor getSale12(String temp_pro_current_date) {
        Cursor cursor;
        String quString = "select Sum(temp_pro_total_value) as temp_pro_total_value,temp_pro_current_date from tempdatastore where temp_pro_current_date='" + temp_pro_current_date + "' GROUP BY temp_pro_current_date";
        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public Cursor getSearchedRetailerFilterByName(String beat_id) {

        Cursor cursor;
        String quString = "select * from retailer_data_insert where l_id='"
                + beat_id + "' AND delete_retailer_status='1' order by c_name asc";


        cursor = objSqliteDB.rawQuery(quString, new String[]{});

        return cursor;
    }

    public Cursor getAddProduct() {
        Cursor cursor_cat;

        String Query_data1 = "select * from product_data_insert_sale_table";
        cursor_cat = objSqliteDB.rawQuery(Query_data1, null);

        return cursor_cat;

    }

    public int checkuserfillanyConterSaleproduct(String orderid) {
        Cursor cursor;
        String query_str = "select * from Distributor_Counter_Sale where counter_sale_order_id='"
                + orderid + "'";
        cursor = objSqliteDB.rawQuery(query_str, null);
        int count = cursor.getCount();
        return count;
    }

    public Cursor checkCounterSaleOrderByGroup() {
        Cursor cursor;
        objSqliteDB = objDataBaseHelper.getReadableDatabase();

        String quString = "select * from "
                + Distributor_Counter_Sale
                + " where delete_status=0 group by counter_sale_order_id ";

        cursor = objSqliteDB.rawQuery(quString, null);

        return cursor;
    }

    public String getCounterSaleTotalsome(String order_id) {
        Cursor cursor;
        String sum = "";
        String Query_data1 = "select SUM(counter_sale_cases) as total_sum from Distributor_Counter_Sale where counter_sale_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data1, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    sum = cursor.getString(cursor.getColumnIndex("total_sum"));

                } while (cursor.moveToNext());

            }
        }
        return sum;
    }

    public Cursor getCounterSaleTotal(String order_id) {
        Cursor cursor;
        String Query_data1 = "select SUM(counter_sale_cases) as total_case, SUM(value_str) as total_value from Distributor_Counter_Sale where counter_sale_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data1, null);

        return cursor;
    }

    public String getCounterSaleTotalsome11(String order_id) {
        Cursor cursor;
        String sum = "";
        String Query_data1 = "select SUM(counter_sale_pieces) as total_sum from Distributor_Counter_Sale where counter_sale_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data1, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    sum = cursor.getString(cursor.getColumnIndex("total_sum"));

                } while (cursor.moveToNext());

            }
        }
        return sum;
    }

    public Cursor getAllCounterSaleSaleProduct(String order_id) {
        Cursor cursor;

        String Query_data = "select * from Distributor_Counter_Sale where counter_sale_order_id='"
                + order_id + "'";
        cursor = objSqliteDB.rawQuery(Query_data, null);

        return cursor;

    }

    public Cursor getcountersharedata(String date, String dealer_id) {
        Cursor cursor;
        String qry = ("SELECT * from Distributor_Counter_Sale  where counter_sale_current_date='"
                + date + "' AND counter_sale_dealer_id ='" + dealer_id + "'");
        cursor = objSqliteDB.rawQuery(qry, null);
        return cursor;
    }


    public String getBaseUrl() {
        Cursor cursor;
        String url_list = "";
        String query = "select * from user_company_detail";
        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    url_list = cursor.getString(cursor.getColumnIndex("base_url"));

                } while (cursor.moveToNext());

            }
        }
        return url_list;
    }

    public String getCompanyId() {
        Cursor cursor;
        String url_list = "";
        String query = "select * from user_company_detail";
        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    url_list = cursor.getString(cursor.getColumnIndex("company_id"));

                } while (cursor.moveToNext());

            }
        }
        return url_list;
    }

    public int getothermoduleId(String id) {
        Cursor cursor;
        int count = 0;
        String query = "select * from login_other_app_module where other_module_id=" + id;
        cursor = objSqliteDB.rawQuery(query, null);
        count = cursor.getCount();
        return count;
    }

    public String getCompanyName() {
        Cursor cursor;
        String url_list = "";
        String query = "select * from user_company_detail";
        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    url_list = cursor.getString(cursor.getColumnIndex("company_name"));

                } while (cursor.moveToNext());

            }
        }
        return url_list;
    }

    public String getSyncUrl() {
        Cursor cursor;
        String url_list = "";
        String query = "select * from user_company_detail";
        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    url_list = cursor.getString(cursor.getColumnIndex("sync_url"));

                } while (cursor.moveToNext());

            }
        }
        return url_list;
    }


    public String getImageSyncUrl() {
        Cursor cursor;
        String image_url = "";
        String query = "select * from user_company_detail";
        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    image_url = cursor.getString(cursor.getColumnIndex("image_url"));

                } while (cursor.moveToNext());

            }
        }
        return image_url;
    }

    public String getUrlList(String code) {
        Cursor cursor;
        String url_list = "";
        String query = "select * from login_url_list where code='" + code + "'";
        cursor = objSqliteDB.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    url_list = cursor.getString(cursor.getColumnIndex("url_list"));

                } while (cursor.moveToNext());

            }
        }
        return url_list;
    }


    public Cursor getAllAppModule() {
        Cursor cur = objSqliteDB.rawQuery("SELECT module_id  , module_name from "
                + LOGIN_APP_MODULE, new String[]{});
        return cur;
    }


    public Cursor getAllSection(String semester_id) {
        return objSqliteDB.rawQuery("SELECT id as _id, name from "
                + LOGIN_SECTION_TABLE + " where semester_id=" + semester_id, new String[]{});
    }

    public Cursor getAllType() {
        return objSqliteDB.rawQuery("SELECT id as _id, name from "
                + LOGIN_SECTION_TABLE , new String[]{});
    }

    public Cursor getAllClassType() {
        return objSqliteDB.rawQuery("SELECT id as _id, name from "
                + LOGIN_CLASS_TYPE_TABLE, new String[]{});
    }

    public Cursor getAllSubject(String paper_type_id) {
        return objSqliteDB.rawQuery("SELECT id as _id, name from "
                + LOGIN_SUBJECT_TABLE + " where paper_type_id=" + paper_type_id, new String[]{});
    }

    public Cursor getAllSemester(String subject_id) {
        return objSqliteDB.rawQuery("SELECT id as _id, name from "
                + LOGIN_SEMESTER_TABLE + " where subject_id=" + subject_id, new String[]{});
    }

    public Cursor getAllPaperType() {
        return objSqliteDB.rawQuery("SELECT id as _id, name from "
                + LOGIN_PAPER_TYPE, new String[]{});
    }

    public Cursor getAllStudnetDetails(String paper_type, String subject_id, String semester_id,
                                       String section_id) {
        Cursor cursor;
        String query = "select * from " + LOGIN_CLASS_STUDENTS_DETAILS_TABLE + " where paper_type_id=" + paper_type +
                " and subject_id=" + subject_id + " and semester_id=" + semester_id +
                " and section_id=" + section_id;

        cursor = objSqliteDB.rawQuery(query, null);

        int count = cursor.getCount();
        return cursor;
    }

    public Cursor getAllTakeStudentAttendance() {
        Cursor cursor;
        String query = "select * from " + TAKE_STUDENT_ATTENDANCE + " where delete_status=0";
        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }


    public Cursor getAllEditAttendanceData() {
        Cursor cursor;
        String query = "select * from " + EDIT_STUDENT_ATTENDANCE_DATA;
        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

    public Cursor getSyncDatetime() {
        Cursor cursor;
        String query = "select * from " + lasttimesyncdateandtime;
        cursor = objSqliteDB.rawQuery(query, null);
        return cursor;
    }

}
