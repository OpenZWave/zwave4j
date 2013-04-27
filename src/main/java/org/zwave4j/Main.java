package org.zwave4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zagumennikov
 */
public class Main {

    private static long homeId;
    private static boolean ready = false;

    public static void main(String[] args) throws IOException {
        NativeLibraryLoader.loadLibrary("zwave4j");

        final Options options = Options.create("D:/private/projects/_3rd party/open-zwave/config", "", "");
        options.addOptionBool("ConsoleOutput", false);
        options.lock();

        final Manager manager = Manager.create();
        manager.addNotificationWatcher(new NotificationWatcher() {
            @Override
            public void onNotification(Notification notification) {
                switch (notification.getType()) {
                    case DRIVER_READY:
                        System.out.println(String.format("Driver ready, home id: %d", notification.getHomeId()));
                        homeId = notification.getHomeId();
                        break;
                    case DRIVER_FAILED:
                        System.out.println(String.format("Driver failed, home id: %d", notification.getHomeId()));
                        break;
                    case DRIVER_RESET:
                        System.out.println(String.format("Driver reset, home id: %d", notification.getHomeId()));
                        break;
                    case NODE_NEW:
                        System.out.println(String.format("Node new, node id: %d", notification.getNodeId()));
                        break;
                    case NODE_ADDED:
                        System.out.println(String.format("Node added, node id: %d", notification.getNodeId()));
                        break;
                    case NODE_REMOVED:
                        System.out.println(String.format("Node removed, node id: %d", notification.getNodeId()));
                        break;
                    case ESSENTIAL_NODE_QUERIES_COMPLETE:
                        System.out.println(String.format("Node essential queries complete, node id: %d", notification.getNodeId()));
                        break;
                    case NODE_QUERIES_COMPLETE:
                        System.out.println(String.format("Node queries complete, node id: %d", notification.getNodeId()));
                        break;
                    case VALUE_ADDED:
                        System.out.println(String.format("Value added, node id: %d",  notification.getNodeId()));
                        break;
                    case VALUE_REMOVED:
                        System.out.println(String.format("Value removed, node id: %d",  notification.getNodeId()));
                        break;
                    case VALUE_CHANGED:
                        System.out.println(String.format("Value changed, node id: %d",  notification.getNodeId()));
                        System.out.println(getValue(notification.getValueId()));
                        break;
                    case VALUE_REFRESHED:
                        System.out.println(String.format("Value refreshed, node id: %d",  notification.getNodeId()));
                        break;
                    case AWAKE_NODES_QUERIES:
                        System.out.println("Awake nodes queried");
                        break;
                    case ALL_NODES_QUERIED:
                        System.out.println("All nodes queried");
                        manager.writeConfig(homeId);
                        ready = true;
                        break;
                    case ALL_NODES_QUERIED_SOME_DEAD:
                        System.out.println("All nodes queried some dead");
                        break;
                    default:
                        System.out.println(notification.getType().name());
                        break;
                }
            }
        });

        manager.addDriver("//./COM21");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        do {
            line = br.readLine();
            if (!ready || line == null) {
                continue;
            }

            if (line.equals("on")) {
                manager.switchAllOn(homeId);
            } else if (line.equals("off")) {
                manager.switchAllOff(homeId);
            }
        } while(line != null && !line.equals("q"));


        br.close();

        manager.removeDriver("//./COM21");
        Manager.destroy();
	    Options.destroy();
    }

    private static Object getValue(ValueId valueId) {
        switch (valueId.getType()) {
            case BOOL:
                AtomicReference<Boolean> b = new AtomicReference<>();
                Manager.get().getValueAsBool(valueId, b);
                return b.get();
            case BYTE:
                AtomicReference<Short> bb = new AtomicReference<>();
                Manager.get().getValueAsByte(valueId, bb);
                return bb.get();
            case DECIMAL:
                AtomicReference<Float> f = new AtomicReference<>();
                Manager.get().getValueAsFloat(valueId, f);
                return f.get();
            case INT:
                AtomicReference<Integer> i = new AtomicReference<>();
                Manager.get().getValueAsInt(valueId, i);
                return i.get();
            case LIST:
                return null;
            case SCHEDULE:
                return null;
            case SHORT:
                AtomicReference<Short> s = new AtomicReference<>();
                Manager.get().getValueAsShort(valueId, s);
                return s.get();
            case STRING:
                AtomicReference<String> ss = new AtomicReference<>();
                Manager.get().getValueAsString(valueId, ss);
                return ss.get();
            case BUTTON:
                return null;
            case RAW:
                AtomicReference<short[]> sss = new AtomicReference<>();
                Manager.get().getValueAsRaw(valueId, sss);
                return sss.get();
            default:
                return null;
        }
    }
}
