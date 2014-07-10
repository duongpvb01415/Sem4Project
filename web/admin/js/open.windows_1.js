function OpenPopup(Url,WindowName,width,height,extras,scrollbars) {
var wide = width;
var high = height;
var additional= extras;
var top = (screen.height-high)/2;
var leftside = (screen.width-wide)/2; newWindow=window.open(''+ Url + 
'',''+ WindowName + '','width=' + wide + ',height=' + high + ',top=' + 
top + ',left=' + leftside + ',features=' + additional + '' + 
',scrollbars=1');
newWindow.focus();
}