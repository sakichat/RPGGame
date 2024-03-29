package ui.view;

import java.util.LinkedList;

/**
 * This NavigationView implements changes of views.
 * @author Siyu Chen
 * @version 0.3
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

    /**
     * This is a method for scenes to back to the former class
     */
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

    /**
     * This is a method for editing scenes to back to a specific class
     * @param viewClass
     */
    public void popTo(Class<?> viewClass){
        while (contentViews.size() > 1 && contentViews.getLast().getClass() != viewClass){
            pop();
        }
    }
}
