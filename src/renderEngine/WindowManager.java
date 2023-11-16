package renderEngine;
import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWVidMode;

public class WindowManager {
    private static long createWindow(int width, int height) {

        if (!glfwInit()){
            throw new IllegalStateException("Failed to init GLFW");
        }

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);

        long window = glfwCreateWindow(width, height, "DrivingSim", 0, 0);

        if (window == 0){
            throw new IllegalArgumentException("Failed to create window");
        }

        GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(window, ((videoMode.width() - width) / 2), ((videoMode.height() - height) / 2) );

        glfwShowWindow(window);

        return window;
    }

    private static void updateWindow(long window){
        glfwPollEvents();
        glfwSwapBuffers(window);
    }

    private static void terminateAll(){
        glfwTerminate();
    }


    /**
     * Creates, shows, and continuously updates the main GLFW window
     * Terminates window at closing time
     *
     * @param width the width of the window
     * @param height the height of the window
     */
    public static void launchWindow(int width, int height){
        long window = createWindow(width, height);

        while (!glfwWindowShouldClose(window)) {
            updateWindow(window);
        }

        terminateAll();
    }
}
