function validate(dialogId, path)
{
	if($('#' + dialogId + ' .ui-messages').text().length == 0)
	{
		navigate(path);
	}
}
function navigate(path) 
{
	var url = window.location.href;
	window.location.href = url.substring(0, url.lastIndexOf("/") + 1) + path;
	
	return false;
}