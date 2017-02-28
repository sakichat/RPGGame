package ui.view;

import java.util.LinkedList;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class NavigationView extends View {

    /**
     * This is a constructor
     */
    public NavigationView() {
        this.setLayout(null);
        this.setSize(1000, 600);
        contentViews = new LinkedList<>();
    }

    /**
     * This is to declare a List for scene classes
     */
    private LinkedList<View> contentViews;

    /**
     * This method is for switching views
     * @param view
     */
    public void push(View view) {
        if (contentViews.size() > 0) {
            remove(contentViews.getLast());
        }

        contentViews.add(view);

        view.setNavigationView(this);
        view.setSize(this.getSize());
        add(view);
        view.viewDidDisplay();

    }

    public void pop() {
        if (contentViews.size() > 0) {
            View view = contentViews.getLast();
            remove(view);
            contentViews.remove(view);
        }

        if (contentViews.size() > 0) {
            View view = contentViews.getLast();
            add(view);
            view.viewDidDisplay();
        }
    }

    public void popTo(Class<?> viewClass){
        while (contentViews.size() > 1 && contentViews.getLast().getClass() != viewClass){
            pop();
        }
    }
}
