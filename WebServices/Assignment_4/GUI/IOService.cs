using System;
using CookComputing.XmlRpc;

namespace GUI
{
	[XmlRpcUrl("http://127.0.0.1:8080/Assignment4/ioservlet")]
	public interface IOService : IXmlRpcProxy
	{
		[XmlRpcMethod("handlers.IOService.listFiles")]
		object listFiles();

		[XmlRpcMethod("handlers.IOService.downloadFile")]
		object downloadFile(string fileName);

		[XmlRpcMethod("handlers.IOService.uploadFile")]
		Boolean uploadFile(string fileName, byte[] fileContent);
	}
}
