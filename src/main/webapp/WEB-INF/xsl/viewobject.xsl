<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="object">
        <html>
            <head>
                <title>View Object</title>
            </head>
            <body>
                <h1>XSLT View</h1>
                <p><a href="/Lab3">to Home</a></p>
                ID: <xsl:value-of select="objectId"/><br/>
                Name: <xsl:value-of select="objectName"/><br/>
                Type: <xsl:value-of select="objectType"/><br/>
                Parent: <xsl:value-of select="objectParent"/>
                <p>Param list:</p>
                <div><xsl:apply-templates select="params"/></div>
                <p>Child list:</p>
                <div><xsl:apply-templates select="childs"/></div>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="params">
        <ul><xsl:apply-templates select="param"/></ul>
    </xsl:template>
    <xsl:template match="childs">
        <ul><xsl:apply-templates select="child"/></ul>
    </xsl:template>
    <xsl:template match="param">
        <li>Object ID: <xsl:value-of select="objectId"/></li>
        <li>Attribute ID: <xsl:value-of select="attributeId"/></li>
        <li>String value: <xsl:value-of select="stringValue"/></li>
        <xsl:if test="numberValue != 0">
            <li>Number value: <xsl:value-of select="numberValue"/></li>
        </xsl:if>
    </xsl:template>
    <xsl:template match="child">
        ID: <xsl:value-of select="objectId"/><br/>
        Name: <xsl:value-of select="objectName"/><br/>
        Type: <xsl:value-of select="objectType"/><br/>
        Parent: <xsl:value-of select="objectParent"/>
    </xsl:template>
</xsl:stylesheet>