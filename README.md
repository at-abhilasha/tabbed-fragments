# TabbedFragmentLibrary
> In order to create a fragment which can hold tabhosts that allows the use of Fragment objects for its tab content (nested fragments), tabhost and viewpager needs to be implemented.
The class `TabbedFragment` in this library is a fragment that implements tabhost, capable of holding fragments as its tab content, and viewpager. 


## How to use it?

### *Step 1*
Download `tabbedfragmentlibrary.aar` file by any of the following ways:
```
wget https://github.com/at-abhilasha/tabbed-fragments/blob/master/aarFolder/tabbedfragmentlibrary.aar
```
OR
```
curl -O https://github.com/at-abhilasha/tabbed-fragments/blob/master/aarFolder/tabbedfragmentlibrary.aar
```
OR Go To this [Link](https://github.com/at-abhilasha/tabbed-fragments/blob/master/aarFolder/tabbedfragmentlibrary.aar) and click on `Raw` button.

### *Step 2*
Copy the `tabbedfragmentlibrary.aar` file in `libs` folder of your project.

Add below code in build.gradle file of your project :
```
allprojects {
   repositories {
      jcenter()
      flatDir {
        dirs 'libs'
      }
   }
}

dependencies {
    compile(name:'tabbedfragmentlibrary', ext:'aar')
}
```

### *Step 3*
Extend `TabbedFragment` class and add tabinfos containing objects of fragments that should be nested.

In the below example `TabbedFragmentExample` is a fragment with tabhost and viewpager which have fragments as their content. It uses default layout present in TabbedFragment class.
```
public class TabbedFragmentExample extends TabbedFragment {
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        addTabInfo(new TabbedFragment.TabInfo("SubFragment1InDefault", "Inner Fragment 1", new SubFragment1()));
        addTabInfo(new TabbedFragment.TabInfo("SubFragment2InDefault", "Inner Fragment 2", new SubFragment2()));
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
```

In the next example `TabbedFragmentCustomViewExample` uses custom layout file.
Just include default layout file in custom layout file as below :
```
    <include
        layout="@layout/tabbed_fragment"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```

`TabbedFragmentCustomViewExample.java`

```
public class TabbedFragmentCustomViewExample extends TabbedFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        addTabInfo(new TabInfo("SubFragment1InCustom", "Inner Fragment 1", new SubFragment1()));
        addTabInfo(new TabInfo("SubFragment2InCustom", "Inner Fragment 2", new SubFragment2()));
        View v = inflater.inflate(R.layout.fragment_custom, container, false);
        return v;
    }
}
```

For more details on above examples, please refer to `tabbed-fragments/app/src/main/java/com/example/tabbedfragmentapplication/`

For source code of tabbedfragmentlibrary, please refer to `tabbed-fragments/tabbedfragmentlibrary/src/main/java/com/support/tabbedfragmentlibrary/`