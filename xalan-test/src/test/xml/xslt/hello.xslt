<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="html" encoding="UTF-8" />

	<xsl:template match="/">
		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="PAGE">
		<HTML>
			<BODY>
				<xsl:apply-templates />
			</BODY>
		</HTML>
	</xsl:template>

	<xsl:template match="EMPLOYEES">
		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="EMPLOYEE">
		<xsl:value-of select="ENAME" />
		<BR />
	</xsl:template>

</xsl:stylesheet>