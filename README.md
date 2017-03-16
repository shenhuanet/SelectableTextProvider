# SelectableTextProvider

[ ![Download](https://api.bintray.com/packages/shenhuanetos/maven/selectableTextProvider/images/download.svg) ](https://bintray.com/shenhuanetos/maven/selectableTextProvider/_latestVersion)

A text view that supports selection and expansion.

## Usage:
* gradle dependencies:
``` java
compile 'com.shenhua.libs:selectableTextProvider:1.0.0'
```
* simple use:
``` java
new SelectableTextProvider.Builder(TextView textView).build();
```
* more function:
```java
SelectableTextProvider selectableTextProvider = new SelectableTextProvider.Builder(textView)
     .setCursorHandleColor(Color.GREEN)
     .setCursorHandleSizeInDp(20)
     .setSelectedColor(Color.BLUE)
     .build();
selectableTextProvider.setSelectListener(new OnSelectListener() {
     @Override
     public void onTextSelected(CharSequence content) {
         Log.d(TAG, "onTextSelected: " + content);
     }
});
```
## OnKeyDown:
If you need to let it respond to the **return KeyEvent** to disappear event, you can do this:
```java
@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
        if (selectableTextProvider.isShowing()){
            selectableTextProvider.hide();
        }
        return true;
    }
    return super.onKeyDown(keyCode, event);
}
```