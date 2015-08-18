<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0" xmlns:xalan="http://xml.apache.org/xslt" xmlns:itso="http://itso.xml.com">
	<xsl:output method="html" encoding="UTF-8" />
	<xsl:template match="/">
		<html>
			<head>
				<title>Accounts</title>
			</head>
			<body>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>
	<xsl:template match="itso:accounts">
		<table bgcolor="#80ffff" border="5" cellspacing="10">
			<tr bgcolor="#ffffff">
				<th>accountID</th>
				<th>accountType</th>
				<th>balance</th>
				<th>interest</th>
				<th>customerInfo</th>
			</tr>
			<xsl:for-each select="/itso:accounts/itso:account">
				<tr bgcolor="#ffffff">
					<td>
						<xsl:value-of select="itso:accountID" />
					</td>
					<td>
						<xsl:value-of select="itso:accountType" />
					</td>
					<td>
						<xsl:value-of select="itso:balance" />
					</td>
					<td>
						<xsl:value-of select="itso:interest" />
					</td>
					<td>
						<xsl:value-of select="itso:customerInfo" />
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>
</xsl:stylesheet>