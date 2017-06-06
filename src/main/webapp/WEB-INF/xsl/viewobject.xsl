<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>View Object</title>
            </head>
            <body>
                <h1>XSLT View</h1>
                <p><a href="/Lab3">Home</a><span><a href="/Lab3/xml/export">export</a></span></p>
                <xsl:for-each select="object">
                    <xsl:value-of select="objectId"/><br/>
                    <xsl:value-of select="objectName"/><br/>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>