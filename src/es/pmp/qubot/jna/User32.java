package es.pmp.qubot;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;

/**
 *
 * @author pmpreciado
 */
public interface User32 extends StdCallLibrary {
    User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);

    
    /**
     * Retrieves a handle to the top-level window whose class name and window name match the specified strings. 
     * This function does not search child windows. This function does not perform a case-sensitive search.
     * 
     * @param lpClassName                       The class name or a class atom created by a previous call to the RegisterClass or RegisterClassEx function. 
     *                                          The atom must be in the low-order word of lpClassName; the high-order word must be zero.
     * 
     *                                          If lpClassName points to a string, it specifies the window class name. 
     *                                          The class name can be any name registered with RegisterClass or RegisterClassEx, or any of the predefined control-class names.
     * 
     * @param lpWindowName                      The window name (the window's title). If this parameter is NULL, all window names match.
     * 
     * @return                                  If the function succeeds, the return value is a handle to the window that has the specified class name and window name.
     *                                          If the function fails, the return value is NULL
     */
    HWND FindWindow(String lpClassName, String lpWindowName);
    
    
    /**
     * Retrieves the dimensions of the bounding rectangle of the specified window.
     * The dimensions are given in screen coordinates that are relative to the upper-left corner of the screen.
     * 
     * @param hWnd                              A handle to the window.
     * @param rect                              A pointer to a RECT structure that receives the screen coordinates of the upper-left and lower-right corners of the window.
     * 
     * @return                                  If the function succeeds, the return value is nonzero.
     *                                          If the function fails, the return value is zero.
     */
    int GetWindowRect(HWND hWnd, int[] rect);
    
    
    /**
     * Determines whether the specified window handle identifies an existing window.
     * 
     * @param hWnd                              A handle to the window to be tested.
     * 
     * @return                                  If the window handle identifies an existing window, the return value is nonzero.
     *                                          If the window handle does not identify an existing window, the return value is zero.
     */
    boolean IsWindow(HWND hWnd);
    
    
    
    /**
     * Brings the thread that created the specified window into the foreground and activates the window. 
     * Keyboard input is directed to the window, and various visual cues are changed for the user. 
     * The system assigns a slightly higher priority to the thread that created the foreground window than it does to other threads.
     * 
     * @param hWnd                              A handle to the window that should be activated and brought to the foreground.
     * 
     * @return                                  If the window was brought to the foreground, the return value is nonzero.
     *                                          If the window was not brought to the foreground, the return value is zero.
     */
    int SetForegroundWindow(HWND hWnd);
    
    
    /**
     * Retrieves a handle to the foreground window (the window with which the user is currently working).
     * The system assigns a slightly higher priority to the thread that creates the foreground window than it does to other threads.
     * 
     * @return                                  The return value is a handle to the foreground window.
     *                                          The foreground window can be NULL in certain circumstances, such as when a window is losing activation.
     */
    HWND GetForegroundWindow();

    
    /**
     * Enumerates all top-level windows on the screen by passing the handle to each window, in turn, to an application-defined callback function. 
     * EnumWindows continues until the last top-level window is enumerated or the callback function returns FALSE.
     * 
     * @param lpEnumFunc                        A pointer to an application-defined callback function. For more information, see EnumWindowsProc.
     * @param arg                               An application-defined value to be passed to the callback function.
     * @return 
     * 
     * @see https://msdn.microsoft.com/es-es/library/windows/desktop/ms633497(v=vs.85).aspx
     */
    boolean EnumWindows(WinUser.WNDENUMPROC lpEnumFunc, Pointer arg);


    /**
     * Copies the text of the specified window's title bar (if it has one) into a buffer.
     * If the specified window is a control, the text of the control is copied. However, GetWindowText cannot retrieve the text of a control in another application.
     * 
     * @param hWnd
     * @param lpString
     * @param nMaxCount
     * @return 
     * 
     * @see https://msdn.microsoft.com/es-es/library/windows/desktop/ms633520(v=vs.85).aspx
     */
    int GetWindowTextA(HWND hWnd, byte[] lpString, int nMaxCount);
    //int GetWindowTextW(HWND hWnd, char[] lpString, int nMaxCount);
    
    
    /**
     * Retrieves the identifier of the thread that created the specified window and, optionally, the identifier of the process that created the window.
     * 
     * @param hWnd                              A handle to the window
     * @param pid                               A pointer to a variable that receives the process identifier. 
     *                                          If this parameter is not NULL, GetWindowThreadProcessId copies the identifier of the process to the variable; otherwise, it does not.
     * 
     * @return                                  The return value is the identifier of the thread that created the window.
     * 
     * @see https://msdn.microsoft.com/es-es/library/windows/desktop/ms633522(v=vs.85).aspx
     */
    int GetWindowThreadProcessId(HWND hWnd, IntByReference pid);
    

    /**
     * Retrieves a handle to a window that has the specified relationship (Z-Order or owner) to the specified window.
     * 
     * @param hWnd                              A handle to a window. The window handle retrieved is relative to this window, based on the value of the uCmd parameter.
     * 
     * @param uCmd                              The relationship between the specified window and the window whose handle is to be retrieved. This parameter can be one of the following values.
     *                                          @see https://msdn.microsoft.com/es-es/library/windows/desktop/ms633515(v=vs.85).aspx
     * @return 
     */
    HWND GetWindow(HWND hWnd, int uCmd);
    
}
