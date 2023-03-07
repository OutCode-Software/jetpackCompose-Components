# IconDropDown example/ reusable

IconDropDown Component

- Dropdown Menu functionality
- Supports trailing icon in dropdown menu
- Easy plug and play model

## steps to use this component

1.Copy and paste IconDropDown.kt file
2.Customize parameters as per project need

```
IconDropDown(
countryList,
hint: "Select Country",
shouldShowIcon: false,
Icons.Filled.Home,
shouldShowDropdownIcon: true,
Icons.Filled.Home
) {
Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
}
```

