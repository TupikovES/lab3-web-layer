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
                <p><a href="/Lab3">to Home</a></p>
                <xsl:for-each select="object">
                    id: <xsl:value-of select="objectId"/><br/>
                    Name: <xsl:value-of select="objectName"/><br/>
                    Param list:<br/>
                    <xsl:for-each select="params/param">
                        String: <xsl:value-of select="stringValue"/><br/>
                        Number: <xsl:value-of select="numberValue"/><br/>
                    </xsl:for-each>
                    <xsl:for-each select="childs/child">
                        <xsl:value-of select="objectId"/><br/>
                        <xsl:value-of select="objectName"/><br/>
                        <xsl:for-each select="params/param">
                            <xsl:value-of select="stringValue"/><br/>
                            <xsl:value-of select="numberValue"/><br/>
                        </xsl:for-each>
                    </xsl:for-each>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>