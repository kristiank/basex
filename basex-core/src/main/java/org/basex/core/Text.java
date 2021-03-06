package org.basex.core;

import static org.basex.core.Lang.*;

import org.basex.core.parse.Commands.CmdAlter;
import org.basex.core.parse.Commands.CmdCreate;
import org.basex.core.parse.Commands.CmdDrop;
import org.basex.core.parse.Commands.CmdIndex;
import org.basex.core.parse.Commands.CmdInfo;
import org.basex.core.parse.Commands.CmdPerm;
import org.basex.core.parse.Commands.CmdRepo;
import org.basex.core.parse.Commands.CmdShow;
import org.basex.util.*;

/**
 * This class contains internationalized text strings, which are used throughout the project.
 * If this class is called first, the Strings are initialized by the {@link Lang} class.
 *
 * @author BaseX Team 2005-15, BSD License
 * @author Christian Gruen
 */
public interface Text {

  // FIXED STRINGS ================================================================================

  /** New line. */
  String NL = Prop.NL;
  /** Colon. */
  String COL = ":";
  /** Colon/space. */
  String COLS = ": ";
  /** Dot. */
  String DOT = ".";
  /** Dots. */
  String DOTS = "...";
  /** List. */
  String LI = "- ";

  /** OK Keyword. */
  String OK = "OK";
  /** ON flag. */
  String ON = "ON";
  /** OFF flag. */
  String OFF = "OFF";
  /** Yes flag. */
  String YES = "yes";
  /** No flag. */
  String NO = "no";
  /** True flag. */
  String TRUE = "true";
  /** False flag. */
  String FALSE = "false";

  /** Local (standalone) mode. */
  String S_STANDALONE = "Standalone";
  /** Start information. */
  String  S_LOCALINFO =
    " [-bcdiLoqrRsuvVwxXz] [input]" + NL +
    "  [input]     XQuery or command file, or query string" + NL +
    "  -b<pars>    Bind external query variables" + NL +
    "  -c<input>   Execute commands from file or string" + NL +
    "  -d          Activate debugging mode" + NL +
    "  -i<input>   Open initial file or database" + NL +
    "  -L          Append newlines to query results" + NL +
    "  -o<output>  Write output to file" + NL +
    "  -q<expr>    Execute XQuery expression" + NL +
    "  -r<num>     Set number of query executions" + NL +
    "  -R          Turn query execution on/off" + NL +
    "  -s<pars>    Set serialization parameter(s)" + NL +
    "  -t[path]    Run tests in file or directory" + NL +
    "  -u          Write updates back to original files" + NL +
    "  -v/V        Show (all) process info" + NL +
    "  -w          Preserve whitespaces from input files" + NL +
    "  -x          Show query plan" + NL +
    "  -X          Show query plan before/after compilation" + NL +
    "  -z          Skip output of results";

  /** Client mode. */
  String S_CLIENT = "Client";
  /** Client start information. */
  String S_CLIENTINFO =
    " [-bcdiLnopPqrRsUvVwxz] [input]" + NL +
    "  [input]     XQuery or command file, or query string" + NL +
    "  -b<pars>    Bind external query variables" + NL +
    "  -c<input>   Execute commands from file or string" + NL +
    "  -d          Activate debugging mode" + NL +
    "  -i<input>   Open initial file or database" + NL +
    "  -L          Append newlines to query results" + NL +
    "  -n<name>    Set server (host) name" + NL +
    "  -o<output>  Write output to file" + NL +
    "  -p<port>    Set server port" + NL +
    "  -P<pass>    Specify user password" + NL +
    "  -q<expr>    Execute XQuery expression" + NL +
    "  -r<num>     Set number of query executions" + NL +
    "  -R          Turn query execution on/off" + NL +
    "  -s<pars>    Set serialization parameter(s)" + NL +
    "  -U<name>    Specify user name" + NL +
    "  -v/V        Show (all) process info" + NL +
    "  -w          Preserve whitespaces from input files" + NL +
    "  -x          Show query execution plan" + NL +
    "  -X          Show query plan before/after compilation" + NL +
    "  -z          Skip output of results";

  /** Server mode. */
  String S_SERVER = "Server";
  /** Server start information. */
  String S_SERVERINFO =
    " [-cdeinpSz] [stop]" + NL +
    "  stop      Stop running server" + NL +
    "  -c<cmds>  Execute initial database commands" + NL +
    "  -d        Activate debugging mode" + NL +
    "  -e<port>  Set event port" + NL +
    "  -n<name>  Set host the server is bound to" + NL +
    "  -p<port>  Set server port" + NL +
    "  -S        Start as service" + NL +
    "  -z        Suppress logging";

  /** GUI mode. */
  String S_GUI = "GUI";
  /** GUI start information. */
  String S_GUIINFO =
    " [file]" + NL +
    "  [file]  Open specified XML or XQuery file";

  /** HTTP information. */
  String S_HTTPINFO =
    " [-dehlnpPsSUz] [stop]" + NL +
    "  stop      Stop running server" + NL +
    "  -d        Activate debugging mode" + NL +
    "  -e<port>  Set event port" + NL +
    "  -h<port>  Set port of HTTP server" + NL +
    "  -l        Start in local mode" + NL +
    "  -n<name>  Set host name of database server" + NL +
    "  -p<port>  Set port of database server" + NL +
    "  -P<pass>  Specify user password" + NL +
    "  -s<port>  Specify port to stop HTTP server" + NL +
    "  -S        Start as service" + NL +
    "  -U<name>  Specify user name" + NL +
    "  -z        Suppress logging";

  /** Bug info. */
  String S_BUGINFO = "Improper use? Potential bug? Your feedback is welcome:";
  /** Console text. */
  String S_CONSOLE = Prop.TITLE + " [%]" + NL;

  /** Localhost. */
  String S_LOCALHOST = "localhost";

  /** Command keyword. */
  String S_ALL = "ALL";
  /** Command keyword. */
  String S_TO = "TO";
  /** Command keyword. */
  String S_QUERY = "query";
  /** Command keyword. */
  String S_PATH = "path";
  /** Command keyword. */
  String S_INPUT = "input";
  /** Command keyword. */
  String S_NAME = "name";
  /** Command keyword. */
  String S_PW = "password";
  /** Command keyword. */
  String S_PKGPATH = "path";
  /** Command keyword. */
  String S_PKGNAME = "name";
  /** Command keyword. */
  String S_PKGDIR = "dir";

  /** Index info. */
  String LI_STRUCTURE = LI + "Structure: ";
  /** Index info. */
  String LI_SIZE = LI + "Size: ";
  /** Index info. */
  String LI_ENTRIES = LI + "Entries: ";

  /** Index info. */
  String HASH = "Hash";
  /** Index info. */
  String SORTED_LIST = "Sorted List";

  /** Query hits. */
  String ITEM = "Item";
  /** Query hits. */
  String ITEMS = "Items";
  /** Global locking. */
  String GLOBAL = "global";
  /** Local locking. */
  String LOCAL = "local";
  /** No locking. */
  String NONE = "none";

  /** Options error. */
  String OPT_OFFSET = "List counter for '%' is invalid.";
  /** Options error. */
  String OPT_BOOLEAN = "Value of '%' must be a boolean.";
  /** Options error. */
  String OPT_NUMBER = "Value of '%' must be a number.";
  /** Options error. */
  String OPT_ONEOF = "Value of '%' must be one of (%).";

  /** "log". */
  String PLOTLOG = "log";

  /** File description: XML Documents. */
  String XML_DOCUMENTS = "XML Documents";
  /** File description: XSL Documents. */
  String XSL_DOCUMENTS = "XSL Documents";
  /** File description: JSON Documents. */
  String JSON_DOCUMENTS = "JSON Documents";
  /** File description: HTML Documents. */
  String HTML_DOCUMENTS = "HTML Documents";
  /** File description: Comma-Separated Values. */
  String CSV_DOCUMENTS = "Comma-Separated Values";
  /** File description: Plain Text. */
  String PLAIN_TEXT = "Plain Text";
  /** File description: ZIP Archives. */
  String ZIP_ARCHIVES = "ZIP Archives";
  /** File description: XML Archives. */
  String XML_ARCHIVES = "XML Archives";
  /** File description: Java archives. */
  String JAVA_ARCHIVES = "Java Archives";
  /** File description: XQuery files. */
  String XQUERY_FILES = "XQuery Files";
  /** File description: Command scripts. */
  String BXS_FILES = "Command Scripts";

  /** "Stack Trace". */
  String STACK_TRACE = "Stack Trace";
  /** Copyright info. */
  String COPYRIGHT = "\u00A9 2005-15 " + Prop.ENTITY;

  // SERVER ===================================================================

  /** Server was started. */
  String SRV_STARTED_PORT_X = lang("srv_started_port_%");
  /** Server was stopped. */
  String SRV_STOPPED_PORT_X = lang("srv_stopped_port_%");
  /** Server is running or permission was denied. */
  String SRV_RUNNING = lang("srv_running");
  /** Ports was specified twice. */
  String PORT_TWICE_X = lang("port_twice_%");
  /** Unknown host. */
  String UNKNOWN_HOST_X = lang("unknown_host_x");
  /** Timeout exceeded. */
  String TIMEOUT_EXCEEDED = lang("timeout_exceeded");
  /** Connection error. */
  String CONNECTION_ERROR = lang("connection_error");
  /** Access denied. */
  String ACCESS_DENIED = lang("access_denied");
  /** User name. */
  String USERNAME = lang("username");
  /** Password. */
  String PASSWORD = lang("password");

  // COMMANDS =================================================================

  /** Console text. */
  String TRY_MORE_X = lang("try_more_%", "help") + NL;
  /** Version information. */
  String VERSINFO = lang("version");

  /** Goodbye information. */
  String[] BYE = { lang("bye1"), lang("bye2"), lang("bye3"), lang("bye4") };

  /** No help available. */
  String NOHELP = lang("no_help");

  /** Command help. */
  String[] HELPCREATE = {
    "[" + CmdCreate.BACKUP + '|' + CmdCreate.DATABASE + '|' +
    CmdCreate.EVENT + '|' + CmdCreate.INDEX + '|' + CmdCreate.USER + "] [...]",
    lang("c_create1"),
    lang("c_create2") + NL +
    LI + CmdDrop.BACKUP + " [" + S_NAME + "]:" + NL +
    "  " + lang("c_create4", S_NAME) + NL +
    LI + CmdCreate.DATABASE + " [" + S_NAME + "] ([" + S_INPUT + "]):"  + NL +
    "  " + lang("c_create3", S_NAME, S_INPUT) + NL +
    LI + CmdCreate.EVENT + " [" + S_NAME + "]: " + NL +
    "  " + lang("c_create9") + NL +
    LI + CmdCreate.INDEX + " [" + CmdIndex.TEXT + '|' + CmdIndex.ATTRIBUTE +
    '|' + CmdIndex.FULLTEXT + "]:" + NL +
    "  " + lang("c_create5") + NL +
    LI + CmdCreate.USER + " [" + S_NAME + "] ([" + S_PW + "]):" + NL +
    "  " + lang("c_create8")
  };

  /** Command help. */
  String[] HELPCOPY = {
    '[' + S_NAME + "] [new" + S_NAME + ']', lang("c_copy1"), lang("c_copy2")
  };

  /** Command help. */
  String[] HELPCHECK = {
    '[' + S_INPUT + ']', lang("c_check1"), lang("c_check2")
  };
  /** Command help. */
  String[] HELPADD = {
    '(' + S_TO + " [" + S_PATH + "]) [" + S_INPUT + ']',
    lang("c_add1"), lang("c_add2", S_INPUT, S_PATH)
  };
  /** Command help. */
  String[] HELPSTORE = {
    '(' + S_TO + " [" + S_PATH + "]) [" + S_INPUT + ']',
    lang("c_store1"), lang("c_store2", S_PATH)
  };
  /** Command help. */
  String[] HELPRETRIEVE = {
    '[' + S_PATH + ']', lang("c_retrieve1"), lang("c_retrieve2", S_PATH)
  };
  /** Command help. */
  String[] HELPDELETE = {
    '[' + S_PATH  + ']', lang("c_delete1"), lang("c_delete2")
  };
  /** Command help. */
  String[] HELPOPEN = {
    '[' + S_NAME + "] ([" + S_PATH + "])", lang("c_open1"), lang("c_open2", S_NAME, S_PATH)
  };
  /** Command help. */
  String[] HELPINFO = {
    "([" + CmdInfo.DATABASE + '|' + CmdInfo.INDEX + '|' +
    CmdInfo.STORAGE + "])",
    lang("c_info1"),
    lang("c_info21") + NL +
    LI + lang("c_info22") + NL +
    LI + CmdInfo.DATABASE + ": " + lang("c_info23") + NL +
    LI + CmdInfo.INDEX + ": " + lang("c_info24") + NL +
    LI + CmdInfo.STORAGE + " [start end] | [" + S_QUERY + "]: " + lang("c_info25")
  };
  /** Command help. */
  String[] HELPCLOSE = {
    "", lang("c_close1"), lang("c_close2")
  };
  /** Command help. */
  String[] HELPLIST = {
    "([" + S_NAME + "] ([" + S_PATH + "]))", lang("c_list1"), lang("c_list2", S_NAME, S_PATH)
  };
  /** Command help. */
  String[] HELPDROP = {
    "[" + CmdDrop.BACKUP + '|' + CmdDrop.DATABASE + '|' + CmdDrop.EVENT + '|' +
      CmdDrop.INDEX + '|' + CmdDrop.USER + "] [...]",
    lang("c_drop1"),
    lang("c_drop2") + NL +
    LI + CmdDrop.BACKUP + " [" + S_NAME + "]:" + NL +
      "  " + lang("c_drop24", S_NAME) + NL +
    LI + CmdDrop.DATABASE + " [" + S_NAME + "]:" + NL +
      "  " + lang("c_drop21") + NL +
    LI + CmdDrop.EVENT + " [" + S_NAME + "]:" + NL +
      "  " + lang("c_drop25", S_NAME) + NL +
    LI + CmdDrop.INDEX + " [" + CmdIndex.TEXT + '|' +
      CmdIndex.ATTRIBUTE + '|' + CmdIndex.FULLTEXT + "]:" + NL +
      "  " + lang("c_drop22") + NL +
    LI + CmdDrop.USER + " [" + S_NAME + "] (" + ON + " [pattern]): " + NL +
      "  " + lang("c_drop23")
  };
  /** Command help. */
  String[] HELPEXPORT = {
    '[' + S_PATH + ']', lang("c_export1"), lang("c_export2", S_PATH)
  };
  /** Command help. */
  String[] HELPOPTIMIZE = {
    '(' + S_ALL + ')', lang("c_optimize1"), lang("c_optimize2", S_ALL)
  };

  /** Command help. */
  String[] HELPXQUERY = {
    '[' + S_QUERY + ']', lang("c_xquery1"), lang("c_xquery2")
  };
  /** Command help. */
  String[] HELPFIND = {
    "[keywords]", lang("c_find1"), lang("c_find2")
  };
  /** Command help. */
  String[] HELPFLUSH = {
    "", lang("c_flush1"), lang("c_flush2")
  };
  /** Command help. */
  String[] HELPRUN = {
    '[' + S_PATH + ']', lang("c_run1"), lang("c_run2", S_PATH)
  };
  /** Command help. */
  String[] HELPTEST = {
    '[' + S_PATH + ']', lang("c_test1"), lang("c_test2", S_PATH)
  };
  /** Command help. */
  String[] HELPEXECUTE = {
    '[' + S_INPUT + ']', lang("c_execute1"), lang("c_execute2", S_INPUT)
  };
  /** Command help. */
  String[] HELPKILL = {
    '[' + S_NAME + ']', lang("c_kill1"), lang("c_kill2")
  };
  /** Command help. */
  String[] HELPRENAME = {
    '[' + S_PATH  + "] [newpath]", lang("c_rename1"), lang("c_rename2")
  };
  /** Command help. */
  String[] HELPREPLACE = {
    '[' + S_PATH  + "] [" + S_INPUT + ']',
    lang("c_replace1"), lang("c_replace2")
  };
  /** Command help. */
  String[] HELPRESTORE = {
    '[' + S_NAME + "-(date)]", lang("c_restore1"), lang("c_restore2")
  };
  /** Command help. */
  String[] HELPSHOW = {
    "[" + CmdShow.BACKUPS + '|' + CmdShow.EVENTS +
    '|' + CmdShow.SESSIONS + '|' + CmdShow.USERS + ']',
    lang("c_show1"),
    lang("c_show21") + NL +
    LI + CmdShow.EVENTS + ": " + lang("c_show26") + NL +
    LI + CmdShow.SESSIONS + ": " + lang("c_show23") + NL +
    LI + CmdShow.USERS + " (" + ON + " [database]): " + lang("c_show24") + NL +
    LI + CmdShow.BACKUPS + ": " + lang("c_show25")
  };
  /** Command help. */
  String[] HELPGRANT = {
    "[" + CmdPerm.NONE + '|' + CmdPerm.READ + '|' + CmdPerm.WRITE + '|' +
    CmdPerm.CREATE + '|' + CmdPerm.ADMIN + "] (" + ON + " [pattern]) " + S_TO +
    " [user]",
    lang("c_grant1"),
    lang("c_grant2")
  };
  /** Command help. */
  String[] HELPALTER = {
    "[" + CmdAlter.DATABASE + '|' + CmdAlter.PASSWORD + '|' + CmdAlter.USER + "] [...]",
    lang("c_alter1"),
    lang("c_alter2") + NL  +
    LI + CmdAlter.DATABASE + " [" + S_NAME + "] [newname]" + NL +
    "  " + lang("c_alterdb") + NL +
    LI + CmdAlter.PASSWORD + " [" + S_NAME + "] [" + S_PW + "]" + NL +
    "  " + lang("c_alterpw") + NL +
    LI + CmdAlter.USER  + " [" + S_NAME + "] ([newname]):" + NL +
    "  " + lang("c_alteruser")
  };
  /** Command help. */
  String[] HELPINSPECT = {
    "", lang("c_inspect1"), lang("c_inspect2")
  };
  /** Command help. */
  String[] HELPSET = {
    "[option] ([value])",
    lang("c_set1", "info"),
    lang("c_set2", "option", "value")
  };
  /** Command help. */
  String[] HELPGET = {
    "[option]", lang("c_get1", "info"), lang("c_get2", "option")
  };
  /** Command help. */
  String[] HELPPASSWORD = {
    "([" + S_PW + "])", lang("c_password1"), lang("c_password2")
  };
  /** Command help. */
  String[] HELPREPO = {
    "[" + CmdRepo.DELETE + '|' + CmdRepo.INSTALL + '|' + CmdRepo.LIST + ']',
    lang("c_repo1"),
    lang("c_repo2") + NL +
    LI + CmdRepo.DELETE + " [" + S_PKGNAME + '|' + S_PKGDIR + "]:" +  NL +
    "  " + lang("c_repo3", S_PKGNAME, S_PKGDIR) + NL +
    LI + CmdRepo.INSTALL + " [" + S_PKGPATH + "]:" + NL +
    "  " + lang("c_repo4", S_PKGPATH) + NL +
    LI + CmdRepo.LIST + ':' + NL +
    "  " + lang("c_repo5")
  };
  /** Command help. */
  String[] HELPHELP = {
    "([command])", lang("c_help1", Prop.NAME), lang("c_help2", "command")
  };
  /** Command help. */
  String[] HELPEXIT = {
    "", lang("c_exit1", Prop.NAME), lang("c_exit2", Prop.NAME)
  };

  // COMMAND INFOS ============================================================

  /** Command timing information. */
  String TIME_NEEDED_X = lang("time_needed") + ": %";
  /** Command syntax information. */
  String SYNTAX_X = lang("syntax") + ": %";
  /** Command execution error. */
  String EXEC_ERROR = lang("exec_error_%") + COL + NL + '%';

  /** No database error. */
  String NO_DB_OPENED = lang("no_db_opened");
  /** Main memory error. */
  String NO_MAINMEM = lang("no_mainmem");
  /** Out of memory error. */
  String OUT_OF_MEM = lang("out_of_mem");
  /** Progress exception. */
  String INTERRUPTED = lang("interrupted");

  /** Unknown command error. */
  String EXPECTING_CMD = lang("expecting_cmd");
  /** Unknown command error. */
  String UNKNOWN_CMD_X = lang("unknown_cmd_%");
  /** Command syntax information. */
  String SINGLE_CMD = lang("single_cmd");
  /** Unknown command error. */
  String UNKNOWN_TRY_X = UNKNOWN_CMD_X + ' ' + lang("try_%", "HELP");
  /** Try "help [...]" to get.. */
  String TRY_SPECIFIC_X = lang("try_specific_%", "HELP [...]") + NL;
  /** Unknown command error. */
  String UNKNOWN_SIMILAR_X = UNKNOWN_CMD_X + ' ' + lang("similar_cmd_%");

  // CREATE COMMAND ===========================================================

  /** Create database question. */
  String CREATE_DB_FILE = lang("create_db_file");
  /** Create database information. */
  String CREATING_DB = lang("creating_db");
  /** Create index information. */
  String CREATING_INDEXES = lang("creating_indexes");
  /** Possible corruption. */
  String DB_CORRUPT = lang("db_corrupt");
  /** "Command was canceled". */
  String COMMAND_CANCELED = lang("command_canceled");
  /** Create database information. */
  String NODES_PARSED_X = " \"%\" (" + lang("nodes_parsed_%") + ')';
  /** Scanner position. */
  String SCANPOS_X_X = "\"%\" (" + lang("line") + " %)";

  /** Finish database creation. */
  String FINISHING_D = lang("finishing") + DOTS;
  /** Create text index. */
  String INDEX_TEXT_D = lang("index_text") + DOTS;
  /** Create attribute index. */
  String INDEX_ATTRIBUTES_D = lang("index_attributes") + DOTS;
  /** Create full-text index. */
  String INDEX_FULLTEXT_D = lang("index_fulltext") + DOTS;

  /** Database created. */
  String DB_CREATED_X_X = lang("db_created_%_%");
  /** Parse error. */
  String NOT_PARSED_X = lang("not_parsed_%");

  /** Resource not found. */
  String RES_NOT_FOUND_X = lang("res_not_found_%");
  /** Resource "%" not found. */
  String RES_NOT_FOUND = lang("res_not_found");
  /** Resource deleted. */
  String RES_DELETED_X_X = lang("res_deleted_%_%");
  /** Resource renamed. */
  String RES_RENAMED_X_X = lang("res_renamed_%_%");
  /** Resource replaced. */
  String RES_REPLACED_X_X = lang("res_replaced_%_%");
  /** Resource added. */
  String RES_ADDED_X = lang("res_added_%");
  /** "Resource Properties". */
  String RES_PROPS = lang("res_props");

  /** Skipped corrupt files. */
  String SKIPPED = lang("skipped");
  /** Info on skipped corrupt files. */
  String MORE_SKIPPED_X = lang("more_skipped_%");
  /** Missing database name. */
  String ENTER_DB_NAME = lang("enter_db_name");
  /** No tokenizer found. */
  String NO_TOKENIZER_X = lang("no_tokenizer_%");
  /** No stemmer found. */
  String NO_STEMMER_X = lang("no_stemmer_%");

  // DATABASE COMMANDS ========================================================

  /** Database not found. */
  String DB_NOT_FOUND_X = lang("db_not_found_%");
  /** Name invalid. */
  String NAME_INVALID_X = lang("name_invalid_%");
  /** Paht invalid. */
  String PATH_INVALID_X = lang("path_invalid_%");
  /** Database pinned. */
  String DB_PINNED_X = lang("db_pinned_%");
  /** Database updated. */
  String DB_UPDATED_X = lang("db_updated_%");
  /** Database closed. */
  String DB_CLOSED_X = lang("db_closed_%");
  /** Database optimized. */
  String DB_OPTIMIZED_X = lang("db_optimized_%");
  /** Database dropped. */
  String DB_DROPPED_X = lang("db_dropped_%");
  /** Database not dropped. */
  String NO_DB_DROPPED = lang("no_db_dropped");
  /** Database not dropped. */
  String DB_NOT_DROPPED_X = lang("db_not_dropped_%");
  /** Database altered. */
  String DB_RENAMED_X = lang("db_renamed_%");
  /** Database not dropped. */
  String DB_NOT_RENAMED_X = lang("db_not_renamed_%");
  /** Database flushed. */
  String DB_FLUSHED_X = lang("db_flushed_%");
  /** Backup of database created. */
  String DB_BACKUP_X = lang("db_backup_%");
  /** Backup of database not created. */
  String DB_NOT_BACKUP_X = lang("db_not_backup_%");
  /** Copy of database created. */
  String DB_COPIED_X = lang("db_copied_%");
  /** Copy of database not created. */
  String DB_NOT_COPIED_X = lang("db_not_copied_%");
  /** Database restored. */
  String DB_RESTORED_X = lang("db_restored_%");
  /** Database not restored. */
  String DB_NOT_RESTORED_X = lang("db_not_restored_%");
  /** Database opened. */
  String DB_OPENED_X = lang("db_opened_%");
  /** Database exported. */
  String DB_EXPORTED_X = lang("db_exported_%");
  /** Database already exists. */
  String DB_EXISTS_X = lang("db_exists_%");
  /** Database was dropped. */
  String BACKUP_DROPPED_X = lang("backup_dropped_%");
  /** Backup was not found. */
  String BACKUP_NOT_FOUND_X = lang("backup_not_found_%");
  /** File could not be deleted. */
  String FILE_NOT_DELETED_X = lang("file_not_deleted_%");
  /** File could not be renamed. */
  String FILE_NOT_RENAMED_X = lang("file_not_renamed_%");
  /** File dialog error. */
  String FILE_NOT_OPENED_X = lang("file_not_opened_%");
  /** File dialog error. */
  String FILE_NOT_SAVED_X = lang("file_not_saved_%");
  /** File dialog replace information. */
  String FILE_EXISTS_X = lang("file_exists_%");
  /** Dir dialog replace information. */
  String FILES_REPLACE_X = lang("files_replace_%");

  /** Index created. */
  String INDEX_CREATED_X_X = lang("index_created_%_%");
  /** Index dropped. */
  String INDEX_DROPPED_X_X = lang("index_dropped_%_%");
  /** Index not dropped. */
  String INDEX_NOT_DROPPED_X = lang("index_not_dropped_%");
  /** Index not available. */
  String NOT_AVAILABLE = lang("not_available");

  // XQUERY COMMAND ===========================================================

  /** Query info: query. */
  String QUERY = lang("query");
  /** Query info: optimized query. */
  String OPTIMIZED_QUERY = lang("optimized_query");
  /** Query info: compiling. */
  String COMPILING = lang("compiling");
  /** Query info: evaluating. */
  String EVALUATING = lang("evaluating");
  /** Query info: querying. */
  String TIMING = lang("timing");
  /** Query info: result . */
  String RESULT = lang("result");
  /** Query info: plan. */
  String QUERY_PLAN = lang("query_plan");

  /** "Query: ". */
  String QUERY_CC = lang("query") + COLS;
  /** "Parsing: ". */
  String PARSING_CC = lang("parsing") + COLS;
  /** "Compiling: ". */
  String COMPILING_CC = lang("compiling") + COLS;
  /** "Evaluating: ". */
  String EVALUATING_CC = lang("evaluating") + COLS;
  /** "Printing: ". */
  String PRINTING_CC = lang("printing") + COLS;
  /** "Total time: ". */
  String TOTAL_TIME_CC = lang("total_time") + COLS;
  /** "Read locking: ". */
  String READ_LOCKING_CC = lang("read_locking") + COLS;
  /** "Write locking: ". */
  String WRITE_LOCKING_CC = lang("write_locking") + COLS;
  /** "Hit(s): ". */
  String HITS_X_CC = lang("hit_s") + COLS;
  /** "Updated: ". */
  String UPDATED_CC = lang("updated") + COLS;
  /** "Printed: ". */
  String PRINTED_CC = lang("printed") + COLS;
  /** "Results: %". */
  String RESULTS_X = lang("results_%");
  /** "Query executed in %". */
  String QUERY_EXECUTED_X_X = lang("query_executed_%_%");

  /** Stopped info. */
  String STOPPED_AT = lang("stopped_at") + ' ';
  /** Line info. */
  String LINE_X = lang("line_%");

  // ADMIN COMMANDS ==========================================================

  /** Show sessions. */
  String SESSIONS_X = lang("sessions_%");
  /** Show events. */
  String EVENTS_X = lang("events_%");
  /** Show packages. */
  String PACKAGES_X = lang("packages_%");
  /** Permission required. */
  String PERM_REQUIRED_X = lang("perm_required_%");
  /** Invalid permissions. */
  String PERM_UNKNOWN_X = lang("perm_unknown_%");
  /** Permission granted. */
  String GRANTED_X_X = lang("granted_%_%");
  /** Permission granted on database. */
  String GRANTED_ON_X_X_X = lang("granted_%_%_%");
  /** Unknown user. */
  String UNKNOWN_USER_X = lang("unknown_user_%");
  /** User dropped. */
  String USER_DROPPED_X = lang("user_dropped_%");
  /** User dropped from database. */
  String USER_DROPPED_X_X = lang("user_dropped_%_%");
  /** User is logged in. */
  String USER_LOGGED_IN_X = lang("user_logged_in_%");
  /** User added. */
  String USER_CREATED_X = lang("user_created_%");
  /** Password changed. */
  String PW_CHANGED_X = lang("pw_changed_%");
  /** User altered. */
  String USER_RENAMED_X_X = lang("user_renamed_%_%");
  /** User unknown. */
  String USER_EXISTS_X = lang("user_exists_%");
  /** Admin user. */
  String ADMIN_STATIC = lang("admin_static");
  /** Killed sessions. */
  String SESSIONS_KILLED_X = lang("sessions_killed_%");
  /** User kills itself. */
  String KILL_SELF_X = lang("kill_self_%");
  /** Event dropped. */
  String EVENT_DROPPED_X = lang("event_dropped_%");
  /** Event added. */
  String EVENT_CREATED_X = lang("event_created_%");
  /** Event not found. */
  String EVENT_UNKNOWN_X = lang("event_unknown_%");
  /** Already watching the event. */
  String EVENT_WATCHED_X = lang("event_watched_%");
  /** Nothing to unwatch. */
  String EVENT_NOT_WATCHED_X = lang("event_not_watched_%");
  /** Event already exists. */
  String EVENT_EXISTS_X = lang("event_exists_%");
  /** Watch Event. */
  String WATCHING_EVENT_X = lang("watching_event_%");
  /** Unwatch Event. */
  String UNWATCHING_EVENT_X = lang("unwatching_event_%");
  /** Package deleted. */
  String PKG_DELETED_X = lang("pkg_deleted_%");
  /** Package installed. */
  String PKG_INSTALLED_X_X = lang("pkg_installed_%_%");
  /** Package replaced. */
  String PKG_REPLACED_X_X = lang("pkg_replaced_%_%");

  // GENERAL COMMANDS =========================================================

  /** "Global option '%' cannot be set". */
  String GLOBAL_OPTION_X = lang("global_option_%");
  /** "Unknown option '%'". */
  String UNKNOWN_OPTION_X = lang("unknown_option_%");
  /** Unknown command error. */
  String UNKNOWN_OPT_SIMILAR_X_X = lang("unknown_option_%") + ' ' + lang("similar_cmd_%");

  // INFO STRINGS =============================================================

  /** Waiting information. */
  String PLEASE_WAIT_D = lang("please_wait") + DOTS;
  /** Statistics information. */
  String CREATE_STATS_D = lang("create_stats") + DOTS;

  /** "Name". */
  String ALL = lang("all");
  /** "Name". */
  String NAME = lang("name");
  /** "Size". */
  String SIZE = lang("size");
  /** "Nodes". */
  String NODES = lang("nodes");
  /** "Type". */
  String TYPE = lang("type");
  /** "Input path". */
  String INPUT_PATH = lang("input_path");
  /** "Timestamp". */
  String TIMESTAMP = lang("timestamp");
  /** "Resources". */
  String RESOURCES = lang("resources");
  /** "Documents". */
  String DOCUMENTS = lang("documents");
  /** "Binaries". */
  String BINARIES = lang("binaries");
  /** "Input Size". */
  String INPUT_SIZE = lang("input_size");
  /** "Encoding". */
  String ENCODING = lang("encoding");
  /** "Method". */
  String METHOD = lang("method");
  /** "Parameters". */
  String PARAMETERS = lang("parameters");
  /** "Path". */
  String PATH = lang("path");

  /** Command info. */
  String RECENTLY_OPENED = lang("recently_opened");
  /** Command info. */
  String RUN_QUERY = lang("run_query");
  /** Command info. */
  String RUN_TESTS = lang("run_tests");
  /** Command info. */
  String INPUT_HISTORY = lang("input_history");

  /** Command info. */
  String FIND_REPLACE = lang("find_replace");
  /** Command info. */
  String REPLACE_ALL = lang("replace_all");
  /** Command info. */
  String REPLACE_WITH = lang("replace_with");
  /** "Match case". */
  String MATCH_CASE = lang("match_case");
  /** "Whole word". */
  String WHOLE_WORD = lang("whole_word");
  /** "Multi-line mode". */
  String MULTI_LINE = lang("multi_line");
  /** "Regular expression". */
  String REGULAR_EXPR = lang("regular_expr");
  /** "% string(s) found.". */
  String STRINGS_FOUND_X = lang("strings_found_%");
  /** "Strings were replaced.". */
  String STRINGS_REPLACED = lang("strings_replaced");

  /** Info on text indexing. */
  String TEXT_INDEX = lang("text_index");
  /** Info on attribute indexing. */
  String ATTRIBUTE_INDEX = lang("attribute_index");
  /** Info on full-text indexing. */
  String FULLTEXT_INDEX = lang("fulltext_index");
  /** Info on path summary. */
  String PATH_INDEX = lang("path_index");
  /** Info on up-to-date. */
  String UP_TO_DATE = lang("up_to_date");

  /** Info on elements. */
  String ELEMENTS = lang("elements");
  /** Info on attributes. */
  String ATTRIBUTES = lang("attributes");
  /** Info on namespaces. */
  String NAMESPACES = lang("namespaces");
  /** Info on index. */
  String OUT_OF_DATE = lang("out_of_date");

  /** "Database Properties". */
  String DB_PROPS = lang("db_props");
  /** "General Information". */
  String GENERAL_INFO = lang("general_info");
  /** "Global Options". */
  String GLOBAL_OPTIONS = lang("global_options");
  /** "Local Options". */
  String LOCAL_OPTIONS = lang("local_options");

  /** "(chopped)". */
  String CHOPPED = '(' + lang("chopped") + ") ";
  /** "(% entries)". */
  String ENTRIES = '(' + lang("entries_%") + ')';
  /** "Error". */
  String ERROR = lang("error");

  // MENU ENTRIES =============================================================

  /** "Database". */
  String DATABASE = lang("database");
  /** "Editor". */
  String EDITOR = lang("editor");
  /** "View". */
  String VIEW = lang("view");
  /** "Options". */
  String OPTIONS = lang("options");
  /** "Visualization". */
  String VISUALIZATION = lang("visualization");
  /** "Help". */
  String HELP = lang("help");

  // GUI COMMANDS =============================================================

  /** Command info. */
  String ABOUT = lang("about_%", Prop.NAME);
  /** Command info. */
  String CLOSE = lang("close");
  /** Command info. */
  String GO_TO_LINE = lang("go_to_line");
  /** Command info. */
  String COLORS = lang("colors");
  /** Command info. */
  String CUT = lang("cut");
  /** Command info. */
  String COPY = lang("copy");
  /** Command info. */
  String SELECT_ALL = lang("select_all");
  /** Command info. */
  String COPY_PATH = lang("copy_path");
  /** Command info. */
  String ADD_AS_IMPORT = lang("add_as_import");
  /** Command info. */
  String NEW = lang("new");
  /** Command info. */
  String DELETE = lang("delete");
  /** Command info. */
  String INSTALL_FROM_URL = lang("install_from_url");
  /** Command info. */
  String INSTALL = lang("install");
  /** Command info. */
  String OPEN_MANAGE = lang("open_manage");
  /** Command info. */
  String EDIT = lang("edit");
  /** Command info. */
  String EXIT = lang("exit");
  /** Command info. */
  String EXPORT = lang("export");
  /** Command info. */
  String FILTER_SELECTED = lang("filter_selected");
  /** Command info. */
  String FULLSCREEN = lang("fullscreen");
  /** Command info. */
  String GO_BACK = lang("go_back");
  /** Command info. */
  String GO_FORWARD = lang("go_forward");
  /** Command info. */
  String GO_UP = lang("go_up");
  /** Command info. */
  String PROPERTIES = lang("properties");
  /** Command info. */
  String PASTE = lang("paste");
  /** Command info. */
  String PREFERENCES = lang("preferences");
  /** Command info. */
  String REDO = lang("redo");
  /** Command info. */
  String GO_HOME = lang("go_home");
  /** Command info. */
  String RT_EXECUCTION = lang("rt_execution");
  /** Command info. */
  String RT_FILTERING = lang("rt_filtering");
  /** Command info. */
  String BUTTONS = lang("buttons");
  /** Command info. */
  String EXPLORER = lang("explorer");
  /** Command info. */
  String FOLDER = lang("folder");
  /** Command info. */
  String PROJECT = lang("project");
  /** Command info. */
  String COMMUNITY = lang("community");
  /** Command info. */
  String CHECK_FOR_UPDATES = lang("check_for_updates");
  /** Command info. */
  String QUERY_INFO = lang("query_info");
  /** Command info. */
  String INPUT_BAR = lang("input_bar");
  /** Command info. */
  String MAP = lang("map");
  /** Command info. */
  String PLOT = lang("plot");
  /** Command info. */
  String STATUS_BAR = lang("status_bar");
  /** Command info. */
  String TABLE = lang("table");
  /** Command info. */
  String TREE = lang("tree");
  /** Command info. */
  String UNDO = lang("undo");
  /** Command info. */
  String OPEN = lang("open");
  /** Command info. */
  String OPEN_EXTERNALLY = lang("open_externally");
  /** Command info. */
  String REOPEN = lang("reopen");
  /** Command info. */
  String SAVE = lang("save");
  /** Command info. */
  String SAVE_AS = lang("save_as");
  /** Command info. */
  String PACKAGES = lang("packages");
  /** Command info. */
  String SHOW_HIDDEN_FILES = lang("show_hidden_files");

  /** Command info. */
  String FONTS_D = lang("fonts") + DOTS;

  // BUTTONS ==================================================================

  /** Button: " OK ". */
  String B_OK = "  " + lang("ok") + "  ";
  /** Button: " yes ". */
  String B_YES = "  " + lang("yes") + "  ";
  /** Button: " no ". */
  String B_NO = "  " + lang("no") + "  ";
  /** Button: "cancel". */
  String CANCEL = lang("cancel");
  /** Button for refreshing. */
  String REFRESH = lang("refresh");

  /** "Search". */
  String FIND = lang("find");
  /** "Find files". */
  String FIND_FILES = lang("find_files");
  /** "Find contents". */
  String FIND_CONTENTS = lang("find_contents");
  /** "Find next ". */
  String FIND_NEXT = lang("find_next");
  /** "Find previous". */
  String FIND_PREVIOUS = lang("find_previous");
  /** "Jump to error". */
  String NEXT_ERROR = lang("next_error");
  /** "Jump to file". */
  String JUMP_TO_FILE = lang("jump_to_file");

  /** "Command". */
  String COMMAND = lang("command");
  /** "XQuery". */
  String XQUERY = lang("xquery");
  /** "Backup". */
  String BACKUP = lang("backup");

  /** Button text for deleting files. */
  String DROP = lang("drop");
  /** Button text for optimization. */
  String OPTIMIZE = lang("optimize");
  /** Button text for renaming databases. */
  String RENAME = lang("rename");
  /** Button text for restoring databases. */
  String RESTORE = lang("restore");

  /** Button text for browsing files/directories. */
  String BROWSE_D = lang("browse") + DOTS;

  /** Button text for creating things. */
  String CREATE = lang("create");
  /** Button for starting the server. */
  String STOP = lang("stop");
  /** Button for deleting all. */
  String DELETE_ALL = lang("delete_all");
  /** Button for adding. */
  String ADD = lang("add");
  /** Button for resetting options. */
  String RESET = lang("reset");
  /** Clear button. */
  String CLEAR = lang("clear");
  /** Filter button. */
  String FILTER = lang("filter");

  // VISUALIZATIONS ===========================================================

  /** "No data available.". */
  String NO_DATA = lang("no_data");
  /** "Not enough pixels". */
  String NO_PIXELS = lang("no_pixels");
  /** "file". */
  String FILE = lang("file");

  // DIALOG WINDOWS ===========================================================

  /** Open dialog - No database. */
  String INFORMATION = lang("information");
  /** Dialog title for choosing a directory. */
  String CHOOSE_DIR = lang("choose_dir");
  /** Command info. */
  String NEW_DIR = lang("new_dir");

  /** Dialog title for choosing a file. */
  String FILE_OR_DIR = lang("file_or_dir");
  /** Use Catalog file Checkbox. */
  String USE_CATALOG_FILE = lang("use_catalog_file");
  /** Use XInclude. */
  String USE_XINCLUDE = lang("use_xinclude");
  /** Use Catalog file not found on CP. */
  String HELP1_USE_CATALOG = lang("help1_use_catalog");
  /** Use Catalog file not found on CP. */
  String HELP2_USE_CATALOG = lang("help2_use_catalog");

  /** Database creation filter. */
  String FILE_PATTERNS = lang("file_patterns");
  /** Name of database. */
  String NAME_OF_DB = lang("name_of_db");
  /** Name of database copy. */
  String NAME_OF_DB_COPY = lang("name_of_db_copy");
  /** Target path. */
  String TARGET_PATH = lang("target_path");

  /** Dialog title for database options. */
  String CREATE_DATABASE = lang("create_database");
  /** Chop whitespaces. */
  String CHOP_WS = lang("chop_ws");
  /** Strip namespaces. */
  String STRIP_NS = lang("strip_ns");
  /** DTD information. */
  String PARSE_DTDS = lang("parse_dtds");
  /** Internal parser. */
  String INT_PARSER = lang("int_parser");
  /** Parse files inside archives. */
  String PARSE_ARCHIVES = lang("parse_archives");
  /** Add remaining files as raw files. */
  String ADD_RAW_FILES = lang("add_raw_files");
  /** "Add Resources". */
  String ADD_RESOURCES = lang("add_resources");
  /** Skip corrupt files. */
  String SKIP_CORRUPT_FILES = lang("skip_corrupt_files");
  /** SAX parsing information. */
  String INPUT_FORMAT = lang("input_format") + COLS;

  /** Full-text index information. */
  String STEMMING = lang("stemming");
  /** Full-text index information. */
  String LANGUAGE = lang("language");
  /** Full-text index information. */
  String CASE_SENSITIVE = lang("case_sensitive");
  /** Full-text index information. */
  String DIACRITICS = lang("diacritics");
  /** Full-text index using stopword list. */
  String STOPWORD_LIST = lang("stopword_list");

  /** Ascending order. */
  String ASCENDING_ORDER = lang("ascending_order");
  /** Merge duplicate lines. */
  String MERGE_DUPLICATES = lang("merge_duplicates");

  /** Format. */
  String FORMAT = lang("format");
  /** Sort. */
  String SORT = lang("sort");
  /** Split input lines. */
  String SPLIT_INPUT_LINES = lang("split_input_lines");
  /** Treat first line as header. */
  String FIRST_LINE_HEADER = lang("first_line_header");
  /** Separator. */
  String SEPARATOR = lang("separator") + COL;
  /** Lax name conversion. */
  String LAX_NAME_CONVERSION = lang("lax_name_conversion");
  /** Parse quotes. */
  String PARSE_QUOTES = lang("parse_quotes");
  /** Merge type information. */
  String MERGE_TYPES = lang("merge_types");
  /** Merge type information. */
  String INCLUDE_STRINGS = lang("include_strings");
  /** Unescape characters. */
  String UNESCAPE_CHARS = lang("unescape_chars");
  /** Liberal parsing. */
  String LIBERAL_PARSING = lang("liberal_parsing");
  /** Backslash. */
  String BACKSLASHES = lang("backslashes");

  /** General info. */
  String GENERAL = lang("general");
  /** General info. */
  String PARSING = lang("parsing");
  /** Name indexes. */
  String NAMES = lang("names");
  /** Value indexes. */
  String INDEXES = lang("indexes");
  /** Full-text index. */
  String FULLTEXT = lang("fulltext");

  /** General info. */
  String PARSER_X = lang("parser_%");

  /** Dialog asking if a new database should be be created. */
  String NEW_DB_QUESTION = lang("no_db_found") + NL + lang("new_db_question");

  /** Users. */
  String USERS_X = lang("users_%");
  /** Confirmation . */
  String ARE_YOU_SURE = lang("are_you_sure");

  /** Alter password. */
  String ALTER_PW = lang("alter_pw");
  /** Invalid. */
  String INVALID_X = lang("invalid_%");
  /** Databases. */
  String DATABASES = lang("databases");
  /** Databases. */
  String DATABASES_X = lang("databases_%");
  /** Backups. */
  String BACKUPS = lang("backups");
  /** Backup(s). */
  String BACKUPS_X = lang("backups_%");
  /** Line number. */
  String LINE_NUMBER = lang("line_number");

  /** Dialog title for renaming a database. */
  String RENAME_DB = lang("rename_db");

  /** Dialog title for copying a database. */
  String COPY_DB = lang("copy_db");
  /** Info for overwriting a database. */
  String OVERWRITE_DB = lang("overwrite_db");
  /** Info for creating an empty database. */
  String EMPTY_DB = lang("empty_db");

  /** Dialog title for managing databases. */
  String MANAGE_DB = lang("manage_db");
  /** Dialog text for dropping a database. */
  String DROPPING_DB_X = lang("dropping_db_%") + NL + ARE_YOU_SURE;
  /** Database only available as backup. */
  String ONLY_BACKUP = lang("only_backup");
  /** Dialog text for dropping a backup. */
  String DROP_BACKUPS_X = lang("drop_backups_%") + NL + ARE_YOU_SURE;
  /** Dialog text for dropping a package. */
  String DELETE_PACKAGES_X = lang("delete_packages_%") + NL + ARE_YOU_SURE;
  /** Dialog text for overwriting a backup. */
  String OVERWRITE_DB_QUESTION = OVERWRITE_DB + NL + ARE_YOU_SURE;

  /** Dialog title for deleting nodes. */
  String DELETE_NODES = lang("delete_nodes");
  /** Dialog title for closing a file. */
  String CLOSE_FILE_X = lang("close_file_%");
  /** Dialog title for deleting a file. */
  String DELETE_FILE_X = lang("delete_file_%");
  /** Dialog title for reopening a file. */
  String REOPEN_FILE_X = lang("reopen_file_%");
  /** Close all. */
  String CLOSE_ALL = lang("close_all");

  /** Dialog title for exporting nodes. */
  String OUTPUT_DIR = lang("output_dir");
  /** Dialog title for exporting nodes. */
  String DIR_NOT_EMPTY = lang("dir_not_empty");

  /** Database path. */
  String DATABASE_PATH = lang("database_path");
  /** Interactions. */
  String GUI_INTERACTIONS = lang("gui_interactions");
  /** Look and feel. */
  String JAVA_LF = "Look & Feel (" + lang("requires_restart") + ')';
  /** Focus. */
  String RT_FOCUS = lang("rt_focus");
  /** Simple file dialog. */
  String SIMPLE_FILE_CHOOSER = lang("simple_file_chooser");
  /** Name display flag. */
  String SHOW_NAME_ATTS = lang("show_name_atts");
  /** Maximum number of hits. */
  String MAX_NO_OF_HITS = lang("max_nr_of_hits");
  /** Language preference. */
  String LANGUAGE_RESTART = lang("language") + " (" + lang("requires_restart") + ')';

  /** Show line numbers. */
  String SHOW_LINE_NUMBERS = lang("show_line_numbers");
  /** Show line margin. */
  String SHOW_LINE_MARGIN = lang("show_line_margin");
  /** Show invisible characters. */
  String SHOW_INVISIBLE = lang("show_invisible");
  /** Show newlines. */
  String SHOW_NEWLINES = lang("show_newlines");
  /** Insert tabs as spaces. */
  String TABS_AS_SPACES = lang("tabs_as_spaces");
  /** Indentation size. */
  String INDENTATION_SIZE = lang("indentation_size");
  /** Mark current line. */
  String MARK_EDITED_LINE = lang("mark_edited_line");
  /** Save before executing file. */
  String SAVE_BEFORE_EXECUTE = lang("save_before_execute");
  /** Automatically add characters. */
  String AUTO_ADD_CHARS = lang("auto_add_chars");
  /** Default file filter. */
  String FILE_FILTER = lang("file_filter");

  /** Comment. */
  String COMMENT = lang("comment");
  /** Dialog title for inserting new data. */
  String INSERT_NEW_DATA = lang("insert_new_data");
  /** Dialog title for updating document data. */
  String EDIT_DATA = lang("edit_data");
  /** Insert value. */
  String VALUE = lang("value");
  /** Dialog title for updating text. */
  String EDIT_X = lang("edit_%");
  /** Dialog title for updating text. */
  String[] NODE_KINDS = { lang("document"), lang("element"), lang("text"),
      lang("attribute"), COMMENT, lang("pi")
  };

  /** Dialog title for choosing a font. */
  String CHOOSE_FONT = lang("choose_font");
  /** Predefined font types. */
  String[] FONT_TYPES = { lang("standard"), lang("bold"), lang("italics") };

  /** Dialog title for treemap color schema. */
  String COLOR_SCHEMA = lang("color_schema");
  /** Color schema information. */
  String RED = lang("red");
  /** Color schema information. */
  String GREEN = lang("green");
  /** Color schema information. */
  String BLUE = lang("blue");

  /** Show attributes. */
  String SHOW_ATTS = lang("show_atts");
  /** Algorithm. */
  String ALGORITHM = lang("algorithm");
  /** Predefined number of layouts. */
  String[] MAP_CHOICES = {
    lang("map_choice1"), lang("map_choice2"), lang("map_choice3"),
    lang("map_choice4"), lang("map_choice5")
  };

  /** Predefined number of layouts. */
  String[] MAP_LAYOUTS = { "Split", "Strip", "Squarified", "Slice & Dice", "Binary" };

  /** Map layout-algorithm. */
  String OFFSETS = lang("offsets");
  /** Size depending on... */
  String RATIO = lang("ratio");

  /** Slim rectangles to text length. */
  String ADJUST_NODES = lang("adjust_nodes");

  /** Info on used main memory. */
  String USED_MEM = lang("used_mem");
  /** Memory information. */
  String TOTAL_MEM_C = lang("total_mem") + COLS;
  /** Memory information. */
  String RESERVED_MEM_C = lang("reserved_mem") + COLS;
  /** Memory information. */
  String MEMUSED_C = USED_MEM + COLS;

  /** License info. */
  String LICENSE = lang("license");
  /** Developer info. */
  String CHIEF_ARCHITECT = lang("chief_architect") + ": " + Prop.AUTHOR;
  /** Contributors info. */
  String TEAM1 = lang("team") + ": " + Prop.TEAM1 + ',';
  /** Developer names. */
  String TEAM2 = Prop.TEAM2;
  /** Developer names. */
  String AND_OTHERS = lang("and_others");
  /** Translation. */
  String TRANSLATION = lang("translation");

  // HELP TEXTS ===============================================================

  /** Memory help. */
  String H_USED_MEM = lang("h_used_mem");
  /** Out of memory error due to database creation. */
  String H_OUT_OF_MEM = NL + lang("h_out_of_mem");

  /** Information on chopping whitespaces. */
  String H_CHOP_WS = lang("h_chop_ws");
  /** Internal parser information. */
  String H_INT_PARSER = lang("h_int_parser");

  /** Path summary information. */
  String H_PATH_INDEX = lang("h_path_index");
  /** Text index information. */
  String H_TEXT_INDEX = lang("h_text_index");
  /** Attribute value index information. */
  String H_ATTR_INDEX = lang("h_attr_index");
  /** Full-text index information. */
  String H_FULLTEXT_INDEX = lang("h_fulltext_index");
  /** Full-text index information. */
  String H_STEMMING = lang("h_stemming");
  /** Full-text index information. */
  String H_LANGUAGE = lang("h_languauge");
  /** Full-text index information. */
  String H_CASE = lang("h_case");
  /** Full-text index information. */
  String H_DIACRITICS = lang("h_diacritics");
  /** Full-text index information. */
  String H_STOPWORDS = lang("h_stopwords");

  /** "Failed to open a browser". */
  String H_BROWSER_ERROR_X = lang("h_browser_error_%");
  /** Database update. */
  String H_DB_FORMAT = lang("h_db_format");
  /** Index update. */
  String H_INDEX_FORMAT = lang("h_index_format");
  /** Dialog title for opening a large database. */
  String H_LARGE_DB = lang("h_large_db") + NL + ' ';
  /** Dialog for downloading a new version. */
  String H_NEW_VERSION = lang("h_new_version");
  /** Dialog title for announcing binary file. */
  String H_FILE_BINARY = lang("h_binary_file") + NL + ' ';

  /** HTML Parser. */
  String H_HTML_PARSER = lang("h_html_parser");
  /** No HTML Parser. */
  String H_NO_HTML_PARSER = lang("h_no_html_parser");

  /** Dummy string to check if all language strings have been assigned. */
  String DUMMY = lang(null);
}
